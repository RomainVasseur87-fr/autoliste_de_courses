package m2i.formation;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.model.Adresse;
import m2i.formation.model.Magasin;

@SpringBootTest
public class MagasinTestBoot {

	@Autowired
	private IMagasinDao magasinDao;
	@Autowired
	private IAdresseDao adresseDao;

	@Test
	public void magasinfindByNom() {
		int startsize = magasinDao.findByNom("auchan").size();
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int endsize = magasinDao.findByNom("auchan").size();
		Assertions.assertEquals(1, endsize - startsize);
	}

	@Test
	public void magasinfindByAdresse() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		Optional<Magasin> magasinFind = magasinDao.findMagasinByAdresse(magasin.getAdresse().getId());
		Assertions.assertNotNull(magasinFind);
		if (magasinFind.isPresent()) {
			Assertions.assertEquals(magasin.getId(), magasinFind.get().getId());
		}
	}
	
	@Test
	public void magasinfindByPartieNom() {
		int startsize = magasinDao.findByPartieNom("%auchan%").size();
		Magasin magasin = new Magasin("auchan toutlabas", null);
		magasin = magasinDao.save(magasin);
		Magasin magasinbis = new Magasin("auchan bourraque", null);
		magasin = magasinDao.save(magasinbis);
		Magasin magasinter = new Magasin("coccinel bourraque", null);
		magasin = magasinDao.save(magasinter);
		int endsize = magasinDao.findByPartieNom("%auchan%").size();
		Assertions.assertEquals(2, endsize - startsize);

	}
	
	@Test
	public void magasinfindByVille() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		List<Magasin> magasins = magasinDao.findByVille(magasin.getAdresse().getVille());
		Assertions.assertNotNull(magasins);
		
		for(Magasin magasinFind : magasins) {
		Assertions.assertEquals(magasin.getAdresse().getVille(), magasinFind.getAdresse().getVille());
		}
	}

}
