package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.model.Process;
import m2i.formation.model.Produit;
import m2i.formation.model.Recette;
import m2i.formation.model.Theme;

@SpringBootTest
public class QuelquesRecettes {
	
	@Autowired
	IProcessDao processDao;
	
	@Autowired
	IProduitDao produitDao;
	
	@Autowired
	IRecetteDao recetteDao;
	
	@Test
	@WithUserDetails("mohamed")
	public void recette1Creation() {
		Produit produit1 = new Produit("Farine", 50L);
		Produit produit2 = new Produit("Oeufs", 3L);
		Produit produit3 = new Produit("Crème liquide", 10L);
		Produit produit4 = new Produit("Carottes râpées", 250L);
		Produit produit5 = new Produit("Gruyère râpé", 100L);
		
		produit1 = produitDao.save(produit1);
		produit2 = produitDao.save(produit2);
		produit3 = produitDao.save(produit3);
		produit4 = produitDao.save(produit4);
		produit5 = produitDao.save(produit5);

		Process process = new Process("Galettes de carottes au fromage - Préparation", "Fouettez 3 oeufs avec 10 cl de crème liquide et 50 g de farine. Ajoutez 250 g de carottes râpées et 100 g de gruyère râpé. Salez et poivrez, mélangez. Laissez reposer 15 min. Faites chauffer 20 g de beurre et 1 cuillère à soupe d'huile dans une poêle. Formez des galettes. Faites dorer à feu doux 5 min de chaque côté. Egouttez sur du papier absorbant et servez.");
		process = processDao.save(process);
		
		Theme theme = new Theme("Entrée");

		Recette recette1 = new Recette();
		recette1.setNom("Galettes de carottes au fromage");
		recette1.setnbConvives(4L);
		recette1.setProcess(process);
		recette1.setIngerients(List.of(produit1, produit2, produit3, produit4, produit5));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);		
		
	}
}