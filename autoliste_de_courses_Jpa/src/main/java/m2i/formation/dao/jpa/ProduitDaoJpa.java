package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IProduitDao;
import m2i.formation.model.Produit;

@Repository
@Transactional
public class ProduitDaoJpa implements IProduitDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produit> findAll() {

		List<Produit> produits = null;

		TypedQuery<Produit> myQuery = em.createQuery("select pro from Produit pro", Produit.class);
		produits = myQuery.getResultList();

		return produits;
	}

	@Override
	public Produit find(Long id) {
		Produit produit = null;

		produit = em.find(Produit.class, id);

		return produit;
	}

	@Override
	public void create(Produit obj) {

		em.persist(obj);

	}

	@Override
	public Produit update(Produit obj) {
		Produit produit = null;

		produit = em.merge(obj);

		return produit;
	}

	@Override
	public void delete(Long id) {

		Produit produit = em.find(Produit.class, id);
		em.remove(produit);

	}

}
