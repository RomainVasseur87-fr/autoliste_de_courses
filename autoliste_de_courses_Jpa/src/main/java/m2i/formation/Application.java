package m2i.formation;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
	private static Application instance = null;

	//private final IAdresseDao adresseDao = new AdresseDaoJpa();
	
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
