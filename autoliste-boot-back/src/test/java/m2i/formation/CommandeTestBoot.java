package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.ICommandeDao;
import m2i.formation.model.Article;
import m2i.formation.model.Commande;

@SpringBootTest
public class CommandeTestBoot {
	@Autowired
	private ICommandeDao commandeDao;
	@Autowired
	private IArticleDao articleDao;
	
	@Test
	public void commandefindById() {
		Commande commande = new Commande("commande01",null);
		commande = commandeDao.save(commande);
		Commande commandeFind = commandeDao.findById(commande.getId());
		Assertions.assertEquals(commande.getId(), commandeFind.getId());
	}
	
	@Test
	public void commandefindByNom() {
		int startSize = commandeDao.findByNom("commande01").size();
		Commande commande = new Commande("commande01",null);
		commande = commandeDao.save(commande);
		int endSize = commandeDao.findByNom("commande01").size();
		Assertions.assertEquals(1, endSize-startSize);
		
	}
	
	@Test
	public void commandefindByArticle() {
		Article article = new Article("pate lustucru", (long) 1000, 0.98, null);
		article = articleDao.save(article);
		int startSize = commandeDao.findByArticle(article.getId()).size();
		Commande commande = new Commande("commande01",List.of(article));
		commande = commandeDao.save(commande);
		int endSize = commandeDao.findByArticle(article.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
}
