package m2i.formation;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.jpa.AdresseDaoJpa;
import m2i.formation.dao.jpa.ArticleDaoJpa;
import m2i.formation.dao.jpa.CategorieDaoJpa;


public class Application {
	private static Application instance = null;

	private final IAdresseDao adresseDao = new AdresseDaoJpa();
	private final IArticleDao articleDao = new ArticleDaoJpa();
	private final ICategorieDao categorieDao = new CategorieDaoJpa();
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-data");

	// empêcher d'instancier le singleton depuis l'extérieur
	private Application() {
	}

	// méthode static de création du singleton
	public static Application getInstance() {
		// on ne crée l'instance qu'au premier appel de la méthode
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	/*

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}
	*/

	public EntityManagerFactory getEmf() {
		return emf;
	}

}
