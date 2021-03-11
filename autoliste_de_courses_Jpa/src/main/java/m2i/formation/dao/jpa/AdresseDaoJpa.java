package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import m2i.formation.Application;
import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

@Repository
@Transactional
public class AdresseDaoJpa implements IAdresseDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Adresse> findAll() {

		List<Adresse> adresses = null;
		TypedQuery<Adresse> myQuery = em.createQuery("select adr from Adresse adr", Adresse.class);
		return adresses = myQuery.getResultList();

	}

	@Override
	public Adresse find(Long id) {
		
		Adresse adresse = null;
		return adresse = em.find(Adresse.class, id);

	}

	@Override
	public void create(Adresse obj) {

		em.persist(obj);

	}

	@Override
	public Adresse update(Adresse obj) {
		
		Adresse adresse = null;
		return adresse = em.merge(obj);

	}

	@Override
	public void delete(Long id) {

		Adresse adresse = em.find(Adresse.class, id);
		em.remove(adresse);

	}

}
