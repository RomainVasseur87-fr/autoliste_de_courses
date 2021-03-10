package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.ICategorieDao;
import m2i.formation.model.Categorie;

@Repository
@Transactional
public class CategorieDaoJpa implements ICategorieDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Categorie> findAll() {
			TypedQuery<Categorie> query = em.createQuery("select c from Categorie c", Categorie.class);
			return query.getResultList();
	}

	@Override
	public Categorie find(Long id) {
		return em.find(Categorie.class, id);
	}

	@Override
	public void create(Categorie obj) {
			em.persist(obj);
	}

	@Override
	public Categorie update(Categorie obj) {
		Categorie categorie = em.merge(obj);
		return categorie;
	}

	@Override
	public void delete(Long id) {
		Categorie categorie = em.find(Categorie.class, id);
		em.remove(categorie);
	}
	
}