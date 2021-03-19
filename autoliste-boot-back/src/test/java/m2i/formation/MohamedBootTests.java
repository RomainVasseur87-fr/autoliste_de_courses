package m2i.formation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Categorie;
import m2i.formation.model.Process;
import m2i.formation.model.Produit;
import m2i.formation.model.Recette;
import m2i.formation.model.Theme;

@SpringBootTest
class MohamedBootTests {

	@Autowired
	IProcessDao processDao;
	@Autowired
	IRecetteDao recetteDao;

	@Autowired
	IProduitDao produitDao;

	@Autowired
	ICategorieDao categorieDao;

	Process process = null;
	@Autowired
	IThemeDao themeDao;

//**************************************** Tests du Process. ****************************************

	@Test
	public void processCreation() {
		int taille1 = processDao.findAll().size();
		process = new Process("Process 1", "Description 1");
		process = processDao.save(process);
		process = new Process("Process 2", "Description 2");
		process = processDao.save(process);
		process = new Process("Process 3", "Description 3");
		process = processDao.save(process);
		process = new Process("Process 4", "Description 4");
		process = processDao.save(process);
		process = new Process("Process 5", "Description 5");
		process = processDao.save(process);
		int taille2 = processDao.findAll().size();
		assertEquals(5, taille2 - taille1);
	}

	@Test
	public void processFindAllProcess() {
		int taille1 = processDao.findAll().size();
		int taille2 = processDao.findAllProcess().size();
		assertEquals(0, taille2 - taille1);
	}
	
	@Test
	public void processFindProcessById() {
		Process process1 = new Process("Process 10", "Description 10");
		process1 = processDao.save(process1);
		Optional<Process> listeProcess1 = processDao.findById(process1.getId());
		Optional<Process> listeProcess2 = processDao.findProcessById(process1.getId());
		assertEquals(listeProcess1, listeProcess2);
	}
	
	@Test
	public void processFindProcessByDescription() {
		double nombre = Math.random();
		String description = "Description " + nombre;
		process = new Process("Process", description);
		process = processDao.save(process);
		Process process2 = processDao.findProcessByDescription(process.getDescription()).get();
		assertEquals(process, process2);
	}
	
	@Test
	public void processFindProcessByNom() {
		double nombre = Math.random();
		String nom = "Process " + nombre;
		process = new Process(nom, "Description");
		process = processDao.save(process);
		Process process2 = processDao.findProcessByNom(process.getNom()).get();
		assertEquals(process, process2);
	}
	
	@Test
	public void processfindRecetteByProcess() {
		double nombre = Math.random();
		String nom = "Process " + nombre;
		process = new Process(nom, "Description");
		process = processDao.save(process);
		
		Recette recette1 = new Recette();
		recette1.setNom("Recette 1");
		recette1.setnbConvives(12L);
		recette1.setProcess(process);
		recette1 = recetteDao.save(recette1);
		
		Recette recette2 = processDao.findRecetteByProcess(process);
		assertEquals(recette1.getId(), recette2.getId());
	}
		
//**************************************** Tests de la catégorie. ****************************************
	
	@Test
	public void categorieCreation() {
		int taille1 = categorieDao.findAll().size();
		Categorie categorie;
		categorie = new Categorie("Catégorie 1");
		categorie = categorieDao.save(categorie);
		categorie = new Categorie("Catégorie 2");
		categorie = categorieDao.save(categorie);
		categorie = new Categorie("Catégorie 3");
		categorie = categorieDao.save(categorie);
		categorie = new Categorie("Catégorie 4");
		categorie = categorieDao.save(categorie);
		categorie = new Categorie("Catégorie 5");
		categorie = categorieDao.save(categorie);
		int taille2 = categorieDao.findAll().size();
		assertEquals(5, taille2 - taille1);
	}
	
	@Test
	public void categorieFindAllCategories() {
		int taille1 = categorieDao.findAll().size();
		int taille2 = categorieDao.findAllCategories().size();
		assertEquals(0, taille2 - taille1);
	}
	
	@Test
	public void categorieFindCategorieById() {
		Categorie categorie = new Categorie("Catégorie");
		categorie = categorieDao.save(categorie);
		Optional<Categorie> categorie1 = categorieDao.findById(categorie.getId());
		Optional<Categorie> categorie2 = categorieDao.findCategorieById(categorie.getId());
		assertEquals(categorie1, categorie2);
	}
	
	@Test
	public void categorieFindcategorieByNom() {
		double nombre = Math.random();
		String nom = "Catégorie " + nombre;
		Categorie categorie = new Categorie(nom);
		categorie = categorieDao.save(categorie);
		Categorie categorie2 = categorieDao.findCategoriesByNom(nom).get();
		assertEquals(categorie, categorie2);
	}
	
	@Test
	public void categorieFindProduitsByCategorie() {
		Categorie categorie1 = new Categorie("Légumes");
		Categorie categorie2 = new Categorie("Viande");
		Categorie categorie3 = new Categorie("Lait");
		
		categorie1 = categorieDao.save(categorie1);
		categorie2 = categorieDao.save(categorie2);
		categorie3 = categorieDao.save(categorie3);
		
		int debutSize = categorieDao.findProduitsByCategorie(categorie1.getId()).size();
		
		Produit produit1 = new Produit("Produit 1", 0);
		produit1.addCategorie(categorie1);
		produit1.addCategorie(categorie2);
		produit1.addCategorie(categorie3);
		produit1 = produitDao.save(produit1);
	
		Produit produit2 = new Produit("Produit 2", 0);
		produit2.addCategorie(categorie2);
		produit2.addCategorie(categorie3);
		produit2 = produitDao.save(produit2);
		
		int finSize = categorieDao.findProduitsByCategorie(categorie1.getId()).size();
		assertEquals(1, finSize - debutSize);
	}
	
//**************************************** Tests du thème. ****************************************

	@Test
	public void ThemeCreation() {
		int taille1 = themeDao.findAll().size();
		Theme theme;
		theme = new Theme("Thème 1");
		theme = themeDao.save(theme);
		theme = new Theme("Thème 2");
		theme = themeDao.save(theme);
		theme = new Theme("Thème 3");
		theme = themeDao.save(theme);
		theme = new Theme("Thème 4");
		theme = themeDao.save(theme);
		theme = new Theme("Thème 5");
		theme = themeDao.save(theme);
		int taille2 = themeDao.findAll().size();
		assertEquals(5, taille2 - taille1);
	}
	
	@Test
	public void themeFindAllTheme() {
		Theme theme = new Theme("Thème");
		theme = themeDao.save(theme);
		List<Theme> theme1 = themeDao.findAll();
		List<Theme> theme2 = themeDao.findAllThemes();
		assertEquals(theme1.size(), theme2.size());
	}
	
	@Test
	public void themeFindThemesById() {
		Theme theme = new Theme("Thème");
		theme = themeDao.save(theme);
		Optional<Theme> theme1 = themeDao.findById(theme.getId());
		Optional<Theme> theme2 = themeDao.findThemesById(theme.getId());
		assertEquals(theme1, theme2);

	}
	
	@Test
	public void themeFindThemesByNom() {
		double nombre = Math.random();
		String nom = "Thème " + nombre;
		List<Theme> themes1 = themeDao.findThemesByNom(nom);
		Theme theme = new Theme(nom);
		theme = themeDao.save(theme);
		List<Theme> themes2 = themeDao.findThemesByNom(nom);
		assertEquals(themes2.size(), themes1.size() + 1);
	}
	
//**************************************** Tests de la recette. ****************************************
	
	@Test
	public void RecetteCreation() {
		int taille1 = recetteDao.findAll().size();
		System.out.print(taille1);
		Recette recette;
		recette = new Recette();
		recette.setNom("Recette 1");
		recette.setnbConvives(2L);		
		recette = recetteDao.save(recette);
		
		recette = new Recette();
		recette.setNom("Recette 2");
		recette.setnbConvives(4L);		
		recette = recetteDao.save(recette);
		
		recette = new Recette();
		recette.setNom("Recette 3");
		recette.setnbConvives(6L);		
		recette = recetteDao.save(recette);
		int taille2 = recetteDao.findAll().size();
		System.out.print(taille1);
		assertEquals(3, taille2 - taille1);
	}
	
	@Test
	public void RecetteFindRecettesByIngredient() {
		double nombre = Math.random();
		String nom = "Produit " + nombre;
		Produit produit = new Produit(nom, 10);
		produit = produitDao.save(produit);
		Recette recette = new Recette();
		recette.setNom("Recette 3");
		recette.setnbConvives(6L);
		recette.setIngerients(List.of(produit));
		recette = recetteDao.save(recette);
		List<Recette> recettes = recetteDao.findRecettesByIngredient(produit);
		assertEquals(recettes.size(), 1);		
	}

	@Test
	public void RecetteFindRecettesByNbConvives() {
		Recette recette = new Recette();
		recette.setNom("Ma recette");
		recette.setnbConvives(40000000000L); // À changer à chaque test unitaire.
		recette = recetteDao.save(recette);
		List<Recette> recettes = recetteDao.findRecettesByNbConvives(recette.getnbConvives());
		assertEquals(recettes.size(), 1);		
	}

	@Test
	public void RecetteFindRecetteByProcess() {
		double nombre = Math.random();
		String description = "Description " + nombre;
		process = new Process("Process", description);
		process = processDao.save(process);
		Recette recette = new Recette();
		recette.setProcess(process);
		recette = recetteDao.save(recette);
		List<Recette> recettes = recetteDao.findMyRecettesByProcess(process);
		assertEquals(recettes.size(), 1);		
	}
	
	@Test
	public void RecetteFindRecettesByNbConvivesGreaterThan() {
		Long nbConvives = 50000000000000L; // À changer à chaque test unitaire.
		Recette recette = new Recette();
		recette.setnbConvives(nbConvives);
		recette = recetteDao.save(recette);
		List<Recette> recettes = recetteDao.findRecettesByNbConvivesGreaterThan(nbConvives);
		assertEquals(recettes.size(), 1);		
	}

	@Test
	public void RecettefindRecettesByNbConvivesSmallerThan() {
		List<Recette> recettes = recetteDao.findAll();
		for (int index = 0 ; index < recettes.size() ; index++) {
			Recette recette = recettes.get(index);
			recette.setnbConvives(100L);
			recette = recetteDao.save(recette);
		}
		Long nbConvives = 0L;
		Recette recette = new Recette();
		recette.setnbConvives(nbConvives);
		recette = recetteDao.save(recette);
		recettes = recetteDao.findRecettesByNbConvivesSmallerThan(nbConvives);
		assertEquals(recettes.size(), 1);		
	}

}