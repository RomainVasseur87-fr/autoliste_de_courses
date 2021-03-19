package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.model.Categorie;
import m2i.formation.model.Produit;

@SpringBootTest
public class ProduitTestBoot {

	@Autowired
	private IProduitDao produitDao;
	@Autowired
	private ICategorieDao categorieDao;

	@Test
	public void produitfindById() {
		Produit produit = new Produit("pates", 500, null);
		produit = produitDao.save(produit);
		Produit produitFind = produitDao.findById(produit.getId());
		Assertions.assertEquals(produit.getId(), produitFind.getId());
	}

	@Test
	public void produitfindByNom() {
		Produit produit = new Produit("pates", 500, null);
		produit = produitDao.save(produit);
		List<Produit> produitsListe = produitDao.findByNom(produit.getNom());
		Assertions.assertNotNull(produitsListe);
		for (Produit produitFind : produitsListe) {
			Assertions.assertNotNull(produitFind);
			Assertions.assertEquals(produit.getNom(), produitFind.getNom());
		}
	}

	@Test
	public void produitfindByCategorie() {
		Categorie categorie = new Categorie("cereales");
		categorie = categorieDao.save(categorie);
		int startsize = produitDao.findByCategorie(categorie.getId()).size();
		Produit produit = new Produit("pates", 500, List.of(categorie));
		produit = produitDao.save(produit);
		int endSize = produitDao.findByCategorie(categorie.getId()).size();
		Assertions.assertEquals(1, endSize - startsize);
	}

}
