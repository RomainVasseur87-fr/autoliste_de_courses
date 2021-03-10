package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IRecetteDao;
import m2i.formation.model.Recette;

@Repository
@Transactional
public class RecetteDaoJpa implements IRecetteDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Recette> findAll() {
			TypedQuery<Recette> query = em.createQuery("select r from Recette r", Recette.class);
			return query.getResultList();
	}

	@Override
	public Recette find(Long id) {
		return em.find(Recette.class, id);
	}

	@Override
	public void create(Recette obj) {
		em.persist(obj);
	}

	@Override
	public Recette update(Recette obj) {
		Recette recette = em.merge(obj);
		return recette;
	}

	@Override
	public void delete(Long id) {
		Recette recette = em.find(Recette.class, id);
		em.remove(recette);
	}
	
}