package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.model.Adresse;
import m2i.formation.model.Article;
import m2i.formation.model.Magasin;

@SpringBootTest
public class ArticleTestBoot {

	@Autowired
	private IArticleDao articleDao;
	@Autowired
	private IMagasinDao magasinDao;
	@Autowired
	private IAdresseDao adresseDao;

	@Test
	public void articlefindByNom() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		List<Article> articlesliste = articleDao.findByNom(article.getNom());
		for (Article articleFind : articlesliste) {

		Assertions.assertEquals("pate lustucru", articleFind.getNom());
		}

	}

	@Test
	public void articlefindByPrix() {
		int starSize = articleDao.findByPrix(0.98).size();
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);
		int endSize = articleDao.findByPrix(0.98).size();

		Assertions.assertEquals(1, endSize - starSize);

	}

	@Test
	public void articlefindByMagasin() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		int starSize = articleDao.findByMagasinNom(magasin.getNom()).size();

		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);
		Article articlebis = new Article("pate panzani", (long) 500, 0.63, magasin);
		articlebis = articleDao.save(articlebis);

		int endSize = articleDao.findByMagasinNom(magasin.getNom()).size();

		Assertions.assertEquals(2, endSize - starSize);

	}

	@Test
	public void articlefindByPrixInf() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		int starSize = articleDao.findByPrixInf( 0.70).size();
		
		System.out.println(starSize);
		
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);
		Article articlebis = new Article("pate panzani", (long) 500, 0.63, magasin);
		articlebis = articleDao.save(articlebis);
		
		int endSize = articleDao.findByPrixInf(0.70).size();
		
		System.out.println(endSize);

		Assertions.assertEquals(1, endSize - starSize);

	}
	
	@Test
	public void articlefindByPrixSup() {
		Adresse adresse = new Adresse(1, "rue de la Paix", "1er étage", "Paris", "75008", "France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("auchan", adresse);
		magasin = magasinDao.save(magasin);
		int starSize = articleDao.findByPrixSup( 0.70).size();
		
		System.out.println(starSize);
		
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);
		Article articlebis = new Article("pate panzani", (long) 500, 0.63, magasin);
		articlebis = articleDao.save(articlebis);
		
		int endSize = articleDao.findByPrixSup(0.70).size();
		
		System.out.println(endSize);

		Assertions.assertEquals(1, endSize - starSize);

	}
}
