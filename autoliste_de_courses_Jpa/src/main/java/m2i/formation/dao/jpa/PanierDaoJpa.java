package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IPanierDao;
import m2i.formation.model.Panier;

@Repository
@Transactional
public class PanierDaoJpa implements IPanierDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Panier> findAll() {

		List<Panier> paniers = null;

		TypedQuery<Panier> myQuery = em.createQuery("select pan from Panier pan", Panier.class);
		paniers = myQuery.getResultList();

		return paniers;
	}

	@Override
	public Panier find(Long id) {
		Panier panier = null;

		panier = em.find(Panier.class, id);

		return panier;
	}

	@Override
	public void create(Panier obj) {

		em.persist(obj);

	}

	@Override
	public Panier update(Panier obj) {
		Panier panier = null;

		panier = em.merge(obj);

		return panier;
	}

	@Override
	public void delete(Long id) {

		Panier panier = em.find(Panier.class, id);
		em.remove(panier);

	}

}
