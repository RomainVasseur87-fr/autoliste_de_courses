package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.ICommandeDao;
import m2i.formation.model.Commande;

@Repository
@Transactional
public class CommandeDaoJpa implements ICommandeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = null;

		TypedQuery<Commande> myQuery = em.createQuery("select com from Commande com", Commande.class);
		commandes = myQuery.getResultList();

		return commandes;
	}

	@Override
	public Commande find(Long id) {
		Commande commande = null;

		commande = em.find(Commande.class, id);

		return commande;
	}

	@Override
	public void create(Commande obj) {

		em.persist(obj);

	}

	@Override
	public Commande update(Commande obj) {
		Commande commande = null;

		commande = em.merge(obj);

		return commande;
	}

	@Override
	public void delete(Long id) {

		Commande commande = em.find(Commande.class, id);
		em.remove(commande);

	}

}
