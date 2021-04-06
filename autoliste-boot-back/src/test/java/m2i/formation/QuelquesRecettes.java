package m2i.formation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Adresse;
import m2i.formation.model.Magasin;
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
	
	@Autowired
	IMagasinDao magasinDao;
	
	@Autowired
	IAdresseDao adresseDao;
	
	@Test
	public void themesCreation() {
		Theme theme;
		theme = new Theme("Appéritif");
		theme = themeDao.save(theme);
		theme = new Theme("Bretagne – cuisine bretonne");
		theme = themeDao.save(theme);
		theme = new Theme("Brochettes (Spécial Barbecue)");
		theme = themeDao.save(theme);
		theme = new Theme("Cakes à croquer !");
		theme = themeDao.save(theme);
		theme = new Theme("Chandeleur");
		theme = themeDao.save(theme);
		theme = new Theme("Cuisine brésilienne");
		theme = themeDao.save(theme);
		theme = new Theme("Cuisine hollandaise");
		theme = themeDao.save(theme);
		theme = new Theme("Cuisine marocaine");
		theme = themeDao.save(theme);
		theme = new Theme("Digestif");
		theme = themeDao.save(theme);
		theme = new Theme("Dossier Shrek");
		theme = themeDao.save(theme);
		theme = new Theme("Epiphanie");
		theme = themeDao.save(theme);
		theme = new Theme("Fête des mères");
		theme = themeDao.save(theme);
		theme = new Theme("Halloween");
		theme = themeDao.save(theme);
		theme = new Theme("Inde – la cuisine indienne");
		theme = themeDao.save(theme);
		theme = new Theme("Italie – la cuisine Italienne");
		theme = themeDao.save(theme);
		theme = new Theme("Macarons");
		theme = themeDao.save(theme);
		theme = new Theme("Mardi-gras");
		theme = themeDao.save(theme);
		theme = new Theme("Mexico !");
		theme = themeDao.save(theme);
		theme = new Theme("Noël");
		theme = themeDao.save(theme);
		theme = new Theme("Normandie – cuisine normande");
		theme = themeDao.save(theme);
		theme = new Theme("Nouvel an chinois : recettes asiatiques");
		theme = themeDao.save(theme);
		theme = new Theme("Noël");
		theme = themeDao.save(theme);
		theme = new Theme("Papillotes de poisson");
		theme = themeDao.save(theme);
		theme = new Theme("Pâques");
		theme = themeDao.save(theme);
		theme = new Theme("Pique-nique !");
		theme = themeDao.save(theme);
		theme = new Theme("plat");
		theme = themeDao.save(theme);
		theme = new Theme("Plat chaud");
		theme = themeDao.save(theme);
		theme = new Theme("Plat froid");
		theme = themeDao.save(theme);
		theme = new Theme("Poisson");
		theme = themeDao.save(theme);
		theme = new Theme("Poulet rôti");
		theme = themeDao.save(theme);
		theme = new Theme("Provence – recettes provençales");
		theme = themeDao.save(theme);
		theme = new Theme("Quiches et tartes");
		theme = themeDao.save(theme);
		theme = new Theme("Ramadan");
		theme = themeDao.save(theme);
		theme = new Theme("Recette à emporter");
		theme = themeDao.save(theme);
		theme = new Theme("Recette au chocolat");
		theme = themeDao.save(theme);
		theme = new Theme("Recette au fromage");
		theme = themeDao.save(theme);
		theme = new Theme("Recette aux épices et aromates");
		theme = themeDao.save(theme);
		theme = new Theme("Recette aux fruits");
		theme = themeDao.save(theme);
		theme = new Theme("Recette d'agneau");
		theme = themeDao.save(theme);
		theme = new Theme("Recette d'apéritifs");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de cakes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de chocolats de Pâques");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de crêpes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de cuisine du monde");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de cuisine régionale");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de féculents");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de fêtes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de légumes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de légumes de printemps");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de pâtes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de pâtisseries");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de petit-déjeuner");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de pizzas");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de plats");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de poissons");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de quiches");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de saison");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de salades");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de sauces");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de soupes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de tartes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette de viandes");
		theme = themeDao.save(theme);
		theme = new Theme("Recette d'oeufs");
		theme = themeDao.save(theme);
		theme = new Theme("Recette faciles");
		theme = themeDao.save(theme);
		theme = new Theme("Recette par cuisson");
		theme = themeDao.save(theme);
		theme = new Theme("Recette pas chères");
		theme = themeDao.save(theme);
		theme = new Theme("Recette pour enfants");
		theme = themeDao.save(theme);
		theme = new Theme("Recette pour frigo vide");
		theme = themeDao.save(theme);
		theme = new Theme("Recette pour recevoir");
		theme = themeDao.save(theme);
		theme = new Theme("Recette rapides");
		theme = themeDao.save(theme);
		theme = new Theme("Recette Thermomix");
		theme = themeDao.save(theme);
		theme = new Theme("Recette Weight Watchers");
		theme = themeDao.save(theme);
		theme = new Theme("Recettes de menu de Pâques");
		theme = themeDao.save(theme);
		theme = new Theme("Recettes pour deux");
		theme = themeDao.save(theme);
		theme = new Theme("Régimes spécifiques et pour les intolérants");
		theme = themeDao.save(theme);
		theme = new Theme("Rhône-Alpes et région lyonnaise");
		theme = themeDao.save(theme);
		theme = new Theme("Saint-Nicolas");
		theme = themeDao.save(theme);
		theme = new Theme("Saint-Patrick");
		theme = themeDao.save(theme);
		theme = new Theme("Saint-Valentin");
		theme = themeDao.save(theme);
		theme = new Theme("Smoothies en folie");
		theme = themeDao.save(theme);
	}
	
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

		Theme theme = new Theme("Recette d'entrées");
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

		Theme theme = new Theme("Recette de desserts");
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

		Theme theme = new Theme("Recette de boissons");
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

		Theme theme = new Theme("Recette de végétariens");
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

		Theme theme = new Theme("Recette de gâteaux");
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
	
	@Test
	public void magasin1Creation() {
		Adresse adresse = new Adresse();
		adresse.setCodePostal("62223");
		adresse.setRue("Rue Mediolanaise");
		adresse.setVille("Saint-Nicolas");
		adresse.setPays("France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("E.Leclerc", adresse);
		magasin = magasinDao.save(magasin);
	}
	
	@Test
	public void magasin2Creation() {
		Adresse adresse = new Adresse();
		adresse.setCodePostal("62000");
		adresse.setComplement("BP 50112");
		adresse.setNumero(225);
		adresse.setRue("Avenue Winston Churchill");
		adresse.setVille("Arras");		
		adresse.setPays("France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("Auchan", adresse);
		magasin = magasinDao.save(magasin);
	}

	@Test
	public void magasin3Creation() {
		Adresse adresse = new Adresse();
		adresse.setCodePostal("62800");
		adresse.setRue("Rue Marie Liétard");
		adresse.setVille("Liévin");		
		adresse.setPays("France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("Carrefour", adresse);
		magasin = magasinDao.save(magasin);
	}
	
	@Test
	public void magasin4Creation() {
		Adresse adresse = new Adresse();
		adresse.setCodePostal("62223");
		adresse.setRue("Route de Béthune");
		adresse.setVille("Sainte-Catherine");		
		adresse.setPays("France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("Intermarché SUPER", adresse);
		magasin = magasinDao.save(magasin);
	}
	
	@Test
	public void magasin5Creation() {
		Adresse adresse = new Adresse();
		adresse.setCodePostal("62118");
		adresse.setRue("Rue Maréchal Foch");
		adresse.setVille("Biache-Saint-Vaast");		
		adresse.setPays("France");
		adresse = adresseDao.save(adresse);
		Magasin magasin = new Magasin("Super U", adresse);
		magasin = magasinDao.save(magasin);
	}
	
}