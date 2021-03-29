package m2i.formation;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Adresse;
import m2i.formation.model.Recette;
import m2i.formation.model.Utilisateur;

@SpringBootTest
public class UtilisateurTestBoot {
	@Autowired
	private IUtilisateurDao utilisateurDao;
	@Autowired
	private IAdresseDao adresseDao;
	@Autowired
	private IRecetteDao recetteDao;
	
	@Test
	public void utilisateurfindByNom() {
		int sizeStart = utilisateurDao.findByNom("bidouille").size();
		Utilisateur utilisateur = new Utilisateur("bidouille", "jean", "jean.bidouille@mail.com");
		utilisateur = utilisateurDao.save(utilisateur);
		int sizeEnd = utilisateurDao.findByNom("bidouille").size();
		Assertions.assertEquals(1, sizeEnd-sizeStart);
	}
	
	@Test
	public void utilisateurfindByPrenom() {
		int sizeStart = utilisateurDao.findByPrenom("jean").size();
		Utilisateur utilisateur = new Utilisateur("bidouille", "jean", "jean.bidouille@mail.com");
		utilisateur = utilisateurDao.save(utilisateur);
		int sizeEnd = utilisateurDao.findByPrenom("jean").size();
		Assertions.assertEquals(1, sizeEnd-sizeStart);
	}
	
	@Test
	public void utilisateurfindUtilisateurByAdresse() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Utilisateur utilisateur = new Utilisateur("bidouille", "jean", "jean.bidouille@mail.com");
		utilisateur.setAdresse(adresse);
		utilisateur = utilisateurDao.save(utilisateur);
		
		Optional<Utilisateur> utilisateurFind = utilisateurDao.findUtilisateurByAdresse(adresse.getId());
		
		Assertions.assertEquals(utilisateur.getId(), utilisateurFind.get().getId());
	}
	
	@Test
	public void utilisateurfindByRecette() {
		Recette recette = new Recette("gloubiboulga", 12L, null, null, null);
		recette = recetteDao.save(recette);
		int sizeStart = utilisateurDao.findByRecette(recette.getId()).size();
		Utilisateur utilisateur = new Utilisateur("bidouille", "jean", "jean.bidouille@mail.com");
		utilisateur.setRecettes(List.of(recette));
		utilisateur = utilisateurDao.save(utilisateur);
		int sizeEnd = utilisateurDao.findByRecette(recette.getId()).size();
		Assertions.assertEquals(1, sizeEnd-sizeStart);
	}


}
