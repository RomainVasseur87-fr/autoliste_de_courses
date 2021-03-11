package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import m2i.formation.Application;
import m2i.formation.dao.IDroitDao;
import m2i.formation.model.Droit;

@Repository
@Transactional
public class DroitDaoJpa implements IDroitDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Droit> findAll() {
		
		List<Droit> droits = new ArrayList<Droit>();
		TypedQuery<Droit> query = em.createQuery("select d from Droit d", Droit.class);
		return droits = query.getResultList();

	}

	@Override
	public Droit find(Long id) {
		
		Droit droit = null;
		return droit = em.find(Droit.class, id);

	}

	@Override
	public void create(Droit obj) {

		em.persist(obj);

	}

	@Override
	public Droit update(Droit obj) {
		
		Droit droit = null;
		return droit = em.merge(obj);

	}

	@Override
	public void delete(Long id) {
		
		Droit droit = em.find(Droit.class, id);
		em.remove(droit);

	}

	
}
