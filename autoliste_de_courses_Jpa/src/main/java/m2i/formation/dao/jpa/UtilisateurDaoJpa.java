package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Utilisateur;

@Repository
@Transactional
public class UtilisateurDaoJpa implements IUtilisateurDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Utilisateur> findAll() {
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		TypedQuery<Utilisateur> query = em.createQuery("select u from Utilisateur u", Utilisateur.class);
		return utilisateurs = query.getResultList();

	}

	@Override
	public Utilisateur find(Long id) {
		
		Utilisateur utilisateur = null;
		return utilisateur = em.find(Utilisateur.class, id);

	}

	@Override
	public void create(Utilisateur obj) {

		em.persist(obj);

	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		
		Utilisateur utilisateur = null;
		return utilisateur = em.merge(obj);

	}

	@Override
	public void delete(Long id) {
		
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.remove(utilisateur);

	}


}
