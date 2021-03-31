package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
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

	@Autowired
	IThemeDao themeDao;

	@Test
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

		Process process = new Process("Galettes de carottes au fromage - Préparation",
				"Fouettez 3 oeufs avec 10 cl de crème liquide et 50 g de farine. Ajoutez 250 g de carottes râpées et 100 g de gruyère râpé. Salez et poivrez, mélangez. Laissez reposer 15 min. Faites chauffer 20 g de beurre et 1 cuillère à soupe d'huile dans une poêle. Formez des galettes. Faites dorer à feu doux 5 min de chaque côté. Egouttez sur du papier absorbant et servez.");
		process = processDao.save(process);

		Theme theme = new Theme("Entrée");
		theme = themeDao.save(theme);

		Recette recette1 = new Recette();
		recette1.setNom("Galettes de carottes au fromage");
		recette1.setnbConvives(4L);
		recette1.setProcess(process);
		recette1.setIngerients(List.of(produit1, produit2, produit3, produit4, produit5));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);
	}

	@Test
	public void recette2Creation() {
		Produit produit1 = new Produit("Yaourts brassés", 2L);
		Produit produit2 = new Produit("Bananes", 2L);
		Produit produit3 = new Produit("Lait écrémé", 2L);

		produit1 = produitDao.save(produit1);
		produit2 = produitDao.save(produit2);
		produit3 = produitDao.save(produit3);

		Process process = new Process("Smoothie yaourt banane - Préparation",
				"Couper les bananes en morceaux et les ajouter aux yaourts dans un blender ainsi que le lait. Mixer le tout et boire à la paille ou au verre ! Ajouter selon les goûts du miel ou du sucre roux !");
		process = processDao.save(process);

		Theme theme = new Theme("Dessert");
		theme = themeDao.save(theme);

		Recette recette1 = new Recette();
		recette1.setNom("Smoothie yaourt banane");
		recette1.setnbConvives(2L);
		recette1.setProcess(process);
		recette1.setIngerients(List.of(produit1, produit2, produit3));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);
	}

	@Test
	public void recette3Creation() {
		Produit produit1 = new Produit("Cuillère à soupe Grenadine", 1L);
		Produit produit2 = new Produit("Jus de citron", 25L);
		Produit produit3 = new Produit("Pamplemousse", 25L);
		Produit produit4 = new Produit("Jus d'orange", 2L);
		Produit produit5 = new Produit("Jus d'ananas", 25L);
		Produit produit6 = new Produit("Limonade ou d'eau gazeuse", 25L);

		produit1 = produitDao.save(produit1);
		produit2 = produitDao.save(produit2);
		produit3 = produitDao.save(produit3);
		produit4 = produitDao.save(produit4);
		produit5 = produitDao.save(produit5);
		produit6 = produitDao.save(produit6);

		Process process = new Process("Cocktail multi-fruits - Préparation",
				"Mélangez tous les ingrédients et servez bien frais, avec des glaçons.");
		process = processDao.save(process);

		Theme theme = new Theme("Boisson");
		theme = themeDao.save(theme);

		Recette recette1 = new Recette();
		recette1.setNom("Cocktail multi-fruits");
		recette1.setnbConvives(6L);
		recette1.setProcess(process);
		recette1.setIngerients(List.of(produit1, produit2, produit3, produit4, produit5, produit6));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);
	}

	@Test
	public void recette4Creation() {
		Produit produit1 = new Produit("Jus de citron jaune", 3L);
		Produit produit2 = new Produit("Jus de citron vert", 2L);
		Produit produit3 = new Produit("Sirop de menthe", 4L);
		Produit produit4 = new Produit("Sirop de sucre de canne", 1L);
		Produit produit5 = new Produit("Menthe fraîche", 1L);
		Produit produit6 = new Produit("Citron", 1L);

		produit1 = produitDao.save(produit1);
		produit2 = produitDao.save(produit2);
		produit3 = produitDao.save(produit3);
		produit4 = produitDao.save(produit4);
		produit5 = produitDao.save(produit5);
		produit6 = produitDao.save(produit6);

		Process process = new Process("Cocktail citron-menthe - Préparation",
				"Mettre dans un shaker, avec de la glace, le sirop de menthe, le sirop de sucre et les jus de citron. Bien agiter. Verser dans un verre, décorer d'une branche de menthe et d'une tranche de citron.");
		process = processDao.save(process);

		Theme theme = new Theme("Boisson");
		theme = themeDao.save(theme);

		Recette recette1 = new Recette();
		recette1.setNom("Cocktail citron-menthe");
		recette1.setnbConvives(1L);
		recette1.setProcess(process);
		recette1.setIngerients(List.of(produit1, produit2, produit3, produit4, produit5, produit6));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);
	}

	@Test
	public void recette5Creation() {
		Produit produit1 = new Produit("Fleur d'oranger", 1L);
		Produit produit2 = new Produit("Noix de coco rapée", 1L);
		Produit produit3 = new Produit("Farine", 2L);
		Produit produit4 = new Produit("Yaourt à la noix de coco", 1L);
		Produit produit5 = new Produit("Sucre", 2L);
		Produit produit6 = new Produit("Huile", 500L);
		Produit produit7 = new Produit("Oeufs entiers", 3);
		Produit produit8 = new Produit("Sucre vanillé", 1L);
		Produit produit9 = new Produit("Levure", 1L);

		produit1 = produitDao.save(produit1);
		produit2 = produitDao.save(produit2);
		produit3 = produitDao.save(produit3);
		produit4 = produitDao.save(produit4);
		produit5 = produitDao.save(produit5);
		produit6 = produitDao.save(produit6);
		produit7 = produitDao.save(produit7);
		produit8 = produitDao.save(produit8);
		produit9 = produitDao.save(produit9);

		Process process = new Process("Gâteau au yaourt à la noix de coco râpée - Préparation", "Mélanger tous les ingrédients, dans l'ordre, dans un saladier. Verser la préparation dans un moule à gâteau préalable beurré ou huilé. Mettre au four à 170°C (thermostat 5-6) pendant 25 minutes environ. Pour savoir s'il est cuit, planter un une lame de couteau dans le gâteau.");
		process = processDao.save(process);

		Theme theme = new Theme("Dessert");
		theme = themeDao.save(theme);

		Recette recette1 = new Recette();
		recette1.setNom("Gâteau au yaourt à la noix de coco râpée");
		recette1.setnbConvives(8L);
		recette1.setProcess(process);
		recette1.setIngerients(
				List.of(produit1, produit2, produit3, produit4, produit5, produit6, produit7, produit8, produit9));
		recette1.setThemes(List.of(theme));
		recette1 = recetteDao.save(recette1);
	}
}