package m2i.formation.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m2i.formation.Application;
import m2i.formation.model.Utilisateur;

public class AutoListeMain {

	public static void main(String[] args) {

		EntityManager em = null;
		EntityTransaction tx = null;

		Utilisateur christopheUtilisateur = null;
		Utilisateur romainUtilisateur = null;
		Utilisateur mohamedUtilisateur = null;
		

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			christopheUtilisateur = new Utilisateur("Varlet", "Christophe", "cva@gmail.com");
			em.persist(christopheUtilisateur);
			romainUtilisateur = new Utilisateur("Vasseur", "Romain", "rva@gmail.com");
			em.persist(romainUtilisateur);
			mohamedUtilisateur = new Utilisateur("Djadane", "Mohamed", "mdj@gmail.com");
			em.persist(mohamedUtilisateur);

			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
