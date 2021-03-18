package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IPanierDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.model.Panier;
import m2i.formation.model.Produit;

@SpringBootTest
public class PanierTestBoot {
	
	@Autowired
	private IPanierDao panierDao;
	@Autowired
	private IProduitDao produitDao;
	
	@Test
	public void panierfindById() {
		Panier panier = new Panier("panier1",null);
		panier = panierDao.save(panier);
		Panier panierFind = panierDao.findById(panier.getId());
		Assertions.assertNotNull(panierFind);
		Assertions.assertEquals(panier.getId(), panierFind.getId());
	}
	
	@Test
	public void panierfindByNom() {
		Panier panier = new Panier("panier1",null);
		panier = panierDao.save(panier);
		List<Panier> paniersListe = panierDao.findByNom(panier.getNom());
		Assertions.assertNotNull(paniersListe);
		for(Panier panierFind : paniersListe) {
			Assertions.assertNotNull(panierFind);
		Assertions.assertEquals(panier.getNom(), panierFind.getNom());
		}
	}
	
	@Test
	public void panierfindByProduit() {
		Produit produit = new Produit("pates",500,null);
		produit = produitDao.save(produit);
		int startsize = panierDao.findByProduit(produit.getId()).size();
		Produit produit2 = new Produit("riz",1000,null);
		produit2 = produitDao.save(produit2);
		Panier panier = new Panier("panier1",List.of(produit, produit2));
		panier = panierDao.save(panier);
		List<Panier> paniersListe = panierDao.findByProduit(produit.getId());
		for(Panier panierFind : paniersListe) {
			Assertions.assertNotNull(panierFind);
		}
		int endSize = panierDao.findByProduit(produit.getId()).size();
		Assertions.assertEquals(1, endSize-startsize);
	}

}
