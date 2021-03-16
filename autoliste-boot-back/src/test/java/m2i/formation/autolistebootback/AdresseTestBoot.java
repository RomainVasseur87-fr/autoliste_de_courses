package m2i.formation.autolistebootback;

import java.util.Optional;

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
	public void adresseDaoCreate() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		adresse = adresseDao.save(adresse);

		Adresse adresseFind = adresseDao.findById(adresse.getId()).get();

		Assertions.assertEquals(1, adresseFind.getNumero());
		Assertions.assertEquals("rue de la Paix", adresseFind.getRue());
		Assertions.assertEquals("1er étage", adresseFind.getComplement());
		Assertions.assertEquals("75008", adresseFind.getCodePostal());
		Assertions.assertEquals("Paris", adresseFind.getVille());
		Assertions.assertEquals("France", adresseFind.getPays());
	}
/*
	@Test
	public void adresseDaoUpdate() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		adresse = adresseDao.save(adresse);

		Adresse adresseFind = adresseDao.findById(adresse.getId()).get();

		adresseFind.setNumero(2);
		adresseFind.setRue("rue sainte catherine");
		adresseFind.setComplement("RDC");
		adresseFind.setCodePostal("33000");
		adresseFind.setVille("Bordeaux");
		adresseFind.setPays("FRANCE");

		adresseFind = adresseDao.save(adresseFind);

		adresseFind = adresseDao.findById(adresse.getId()).get();

		Assertions.assertEquals(2, adresseFind.getNumero());
		Assertions.assertEquals("rue sainte catherine", adresseFind.getRue());
		Assertions.assertEquals("RDC", adresseFind.getComplement());
		Assertions.assertEquals("33000", adresseFind.getCodePostal());
		Assertions.assertEquals("Bordeaux", adresseFind.getVille());
		Assertions.assertEquals("FRANCE", adresseFind.getPays());

	}

	@Test
	public void adresseDaoDelete() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		;
		adresse = adresseDao.save(adresse);

		Adresse adresseFind = adresseDao.findById(adresse.getId()).get();

		adresseDao.deleteById(adresseFind.getId());

		Optional<Adresse> adresseOpt = adresseDao.findById(adresse.getId());

		if (adresseOpt.isPresent()) {
			Assertions.fail("L'adresse na pas été supprimée");
		}
	}

	@Test
	public void adresseDaoFindAll() {
		int sizeStart = adresseDao.findAll().size();

		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		;
		adresse = adresseDao.save(adresse);

		Adresse adresseBis = new Adresse(2, "place du centre", "", "59000", "Lille", "France");
		adresseBis = adresseDao.save(adresseBis);

		int sizeEnd = adresseDao.findAll().size();

		Assertions.assertEquals(2, sizeEnd - sizeStart);
	}

	@Test
	public void adresseDaoFindByCodePostal() {
		int sizeStart = adresseDao.findByCodePostal("75008").size();

		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		;
		adresse = adresseDao.save(adresse);

		Adresse adresseBis = new Adresse(2, "place du centre", "", "59000", "Lille", "France");
		adresseBis = adresse = adresseDao.save(adresseBis);

		Adresse adresseTer = new Adresse(1, "place de l'Elysée", "", "75008", "Paris", "France");
		adresseTer = adresseDao.save(adresseTer);

		int sizeEnd = adresseDao.findByCodePostal("75008").size();

		Assertions.assertEquals(2, sizeEnd - sizeStart);
	}

	@Test
	public void adresseDaoFindByUtilisateur() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "75008", "Paris", "France");
		;
		adresse = adresseDao.save(adresse);

		Utilisateur eric = new Utilisateur("SULTAN", "Eric", "eric@gmail.com");
		eric.setAdresse(adresse);
		eric = utilisateurDao.save(eric);

		Adresse adresseFind = adresseDao.findByUtilisateur(eric.getId());

		Assertions.assertNotNull(adresseFind);
		Assertions.assertEquals(adresse.getId(), adresseFind.getId());
	}
*/
}
