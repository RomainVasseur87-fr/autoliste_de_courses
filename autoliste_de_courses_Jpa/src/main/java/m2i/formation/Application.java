package m2i.formation;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.ICommandeDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.dao.IPanierDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.jpa.AdresseDaoJpa;
import m2i.formation.dao.jpa.ArticleDaoJpa;
import m2i.formation.dao.jpa.CategorieDaoJpa;
import m2i.formation.dao.jpa.CommandeDaoJpa;
import m2i.formation.dao.jpa.MagasinDaoJpa;
import m2i.formation.dao.jpa.PanierDaoJpa;
import m2i.formation.dao.jpa.ProduitDaoJpa;


public class Application {
	private static Application instance = null;

	private final IAdresseDao adresseDao = new AdresseDaoJpa();
	private final IArticleDao articleDao = new ArticleDaoJpa();
	private final ICategorieDao categorieDao = new CategorieDaoJpa();
	private final ICommandeDao commandeDao = new CommandeDaoJpa();
	private final IMagasinDao magasinDao = new MagasinDaoJpa();
	private final IPanierDao panierDao = new PanierDaoJpa();
	private final IProduitDao produitDao = new ProduitDaoJpa();
	
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

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IAdresseDao getAdresseDao() {
		return adresseDao;
	}

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public ICategorieDao getCategorieDao() {
		return categorieDao;
	}

	public ICommandeDao getCommandeDao() {
		return commandeDao;
	}

	public IMagasinDao getMagasinDao() {
		return magasinDao;
	}

	public IPanierDao getPanierDao() {
		return panierDao;
	}

	public IProduitDao getProduitDao() {
		return produitDao;
	}

	
}
