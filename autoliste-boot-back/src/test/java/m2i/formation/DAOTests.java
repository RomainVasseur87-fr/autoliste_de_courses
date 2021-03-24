package m2i.formation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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

class DAOTests {

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
		Long identifiant1 = process1.getId();
		
		Process process2 = processDao.findById(identifiant1).get();
		Long identifiant2 = process2.getId();
		
		assertEquals(identifiant1, identifiant2);
	}
	
	@Test
	public void processFindProcessByDescription() {
		double nombre = Math.random();
		String description = "Description " + nombre;
		List<Process> process1 = processDao.findProcessByDescription(description);
		
		process = new Process("Process", description);
		process = processDao.save(process);
		List<Process> process2 = processDao.findProcessByDescription(description);
		assertEquals(process2.size() - process1.size() , 1);
	}
	
	@Test
	public void processFindProcessByNom() {
		double nombre = Math.random();
		String nom = "Process " + nombre;
		List<Process> process1 = processDao.findProcessByNom(nom);
		
		process = new Process(nom, "Description");
		process = processDao.save(process);
		List<Process> process2 = processDao.findProcessByNom(nom);
		
		assertEquals(process2.size(), process1.size() + 1);
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
		Categorie categorie1 = new Categorie("Catégorie");
		categorie1 = categorieDao.save(categorie1);
		Long identifiant1 = categorie1.getId();
		
		Categorie categorie2 = categorieDao.findById(identifiant1).get();
		Long identifiant2 = categorie2.getId();
		
		assertEquals(identifiant1, identifiant2);
	}
	
	@Test
	public void categorieFindcategorieByNom() {
		double nombre = Math.random();
		String nom = "Catégorie " + nombre;
		List<Categorie> categorie1 = categorieDao.findCategoriesByNom(nom);
		
		Categorie categorie = new Categorie(nom);
		categorie = categorieDao.save(categorie);
		int nombre1 = categorie1.size();
		
		List<Categorie> categorie2 = categorieDao.findCategoriesByNom(nom);
		int nombre2 = categorie2.size();
		
		assertEquals(nombre2 - nombre1, 1);
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
		Theme theme1 = new Theme("Thème");
		theme1 = themeDao.save(theme1);
		Long identifiant1 = theme1.getId();
		
		Theme theme2 = themeDao.findById(identifiant1).get();
		Long identifiant2 = theme2.getId();
		
		assertEquals(identifiant1, identifiant2);
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
	public void recetteFindRecettesById() {
		Recette recette1;
		recette1 = new Recette();
		recette1.setNom("Recette 1234567890");
		recette1.setnbConvives(5L);		
		recette1 = recetteDao.save(recette1);

		Long identifiant1 = recette1.getId();
		
		Recette recette2 = recetteDao.findById(identifiant1).get();
		Long identifiant2 = recette2.getId();
		
		assertEquals(identifiant1, identifiant2);
	}
	
	@Test
	public void recetteFindRecettesByNom() {
		
		double nombre = Math.random();
		String nom = "Recette " + nombre;

		List<Recette> recettes1 = recetteDao.findRecettesByNom(nom);
		int identifiant1 = recettes1.size();
		
		Recette recette1;
		recette1 = new Recette();
		recette1.setNom(nom);
		recette1.setnbConvives(5L);		
		recette1 = recetteDao.save(recette1);

		List<Recette> recettes2 = recetteDao.findRecettesByNom(nom);
		int identifiant2 = recettes2.size();
		assertEquals(identifiant2 - identifiant1, 1);
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
		List<Recette> recettes = recetteDao.findRecettesByIngredient(produit.getId());
		assertEquals(recettes.size(), 1);		
	}

	@Test
	public void RecetteFindRecettesByNbConvives() {
		Long nbConvives = 40000000000L;
		List<Recette> recettes1 = recetteDao.findRecettesByNbConvives(nbConvives);
		int taille1 = recettes1.size();		
		
		Recette recette = new Recette();
		recette.setNom("Ma recette");
		recette.setnbConvives(nbConvives);
		recette = recetteDao.save(recette);
		
		List<Recette> recettes2 = recetteDao.findRecettesByNbConvives(nbConvives);
		int taille2 = recettes2.size();		

		assertEquals(taille2 - taille1, 1);		
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
		List<Recette> recettes = recetteDao.findRecettesByProcess(process.getId());
		assertEquals(recettes.size(), 1);		
	}
	
	@Test
	public void RecetteFindRecettesByNbConvivesGreaterThan() {
		Long nbConvives = 100L;
		List<Recette> recettes1 = recetteDao.findRecettesByNbConvivesGreaterThan(nbConvives);
		int nombre1 = recettes1.size();
		
		Recette recette = new Recette();
		recette.setnbConvives(nbConvives);
		recette = recetteDao.save(recette);
		
		List<Recette> recettes2 = recetteDao.findRecettesByNbConvivesGreaterThan(nbConvives);
		int nombre2 = recettes2.size();
		assertEquals(nombre2 - nombre1, 1);		
	}

	@Test
	public void RecettefindRecettesByNbConvivesSmallerThan() {
		Long nbConvives = 100L;
		List<Recette> recettes1 = recetteDao.findRecettesByNbConvivesSmallerThan(nbConvives);
		int nombre1 = recettes1.size();
		
		Recette recette = new Recette();
		recette.setnbConvives(nbConvives);
		recette = recetteDao.save(recette);
		
		List<Recette> recettes2 = recetteDao.findRecettesByNbConvivesSmallerThan(nbConvives);
		int nombre2 = recettes2.size();
		assertEquals(nombre2 - nombre1, 1);
	}
	
	@Test
	public void RecetteFindRecettesByTheme() {
		Theme theme1 = new Theme("AAAAA1");
		theme1 = themeDao.save(theme1);
		Theme theme2 = new Theme("BBBBB2");
		theme2 = themeDao.save(theme2);
		Theme theme3 = new Theme("CCCCC3");
		theme3 = themeDao.save(theme3);
		Theme theme4 = new Theme("DDDDD4");
		theme4 = themeDao.save(theme4);
		Theme theme5 = new Theme("EEEEE5");
		theme5 = themeDao.save(theme5);
		
		int nombre1 = recetteDao.findRecettesByTheme(theme1.getId()).size();
		
		Recette recette;
		recette = new Recette();
		recette.setNom("Recette 1234567890");
		recette.setThemes(List.of(theme1, theme2, theme3, theme4, theme5));
		
		recette = recetteDao.save(recette);
			
		int nombre2 = recetteDao.findRecettesByTheme(theme1.getId()).size();
		
		assertEquals(nombre2 - nombre1, 1);
	}
	
}