package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IMagasinDao;

import m2i.formation.model.Magasin;

@Repository
@Transactional
public class MagasinDaoJpa implements IMagasinDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Magasin> findAll() {
		List<Magasin> magasins = null;

		TypedQuery<Magasin> myQuery = em.createQuery("select mag from Magasin mag", Magasin.class);
		magasins = myQuery.getResultList();

		return magasins;
	}

	@Override
	public Magasin find(Long id) {
		Magasin magasin = null;

		magasin = em.find(Magasin.class, id);

		return magasin;
	}

	@Override
	public void create(Magasin obj) {

		em.persist(obj);

	}

	@Override
	public Magasin update(Magasin obj) {
		Magasin magasin = null;

		magasin = em.merge(obj);

		return magasin;
	}

	@Override
	public void delete(Long id) {

		Magasin magasin = em.find(Magasin.class, id);
		em.remove(magasin);

	}

}
