package m2i.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Adresse;
import m2i.formation.model.Utilisateur;

@SpringBootTest
public class AdresseTestBoot {

	@Autowired
	private IAdresseDao adresseDao;
	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Test
	public void adresseDaoFindByVille() {
		int sizeStart = adresseDao.findByVille("Paris").size();
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Adresse adresseBis = new Adresse(1, "place du centre", "", "Lille", "59000", "France");
		adresseBis = adresseDao.save(adresseBis);
		Adresse adresseTer = new Adresse(1, "place de l'Elysée", "", "Paris", "75008", "France");
		adresseTer = adresseDao.save(adresseTer);
		int sizeEnd = adresseDao.findByVille("Paris").size();
		Assertions.assertEquals(2, sizeEnd - sizeStart);
	}

	@Test
	public void adresseDaoFindByCodePostal() {
		int sizeStart = adresseDao.findByCodePostal("75008").size();
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Adresse adresseBis = new Adresse(1, "place du centre", "", "Lille", "59000", "France");
		adresseBis = adresseDao.save(adresseBis);
		Adresse adresseTer = new Adresse(1, "place de l'Elysée", "", "Paris", "75008", "France");
		adresseTer = adresseDao.save(adresseTer);
		int sizeEnd = adresseDao.findByCodePostal("75008").size();
		Assertions.assertEquals(2, sizeEnd - sizeStart);
	}

	@Test
	public void adresseDaofindByUtilisateur() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);

		Utilisateur eric = new Utilisateur("SULTAN", "Eric", "eric@gmail.com");
		eric.setAdresse(adresse);
		eric = utilisateurDao.save(eric);

		Adresse adresseFind = adresseDao.findByUtilisateur(eric.getId());

		Assertions.assertNotNull(adresseFind);
		Assertions.assertEquals(adresse.getId(), adresseFind.getId());
	}

}
