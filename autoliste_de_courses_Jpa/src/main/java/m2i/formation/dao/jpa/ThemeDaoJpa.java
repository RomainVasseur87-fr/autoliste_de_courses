package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Theme;

@Repository
@Transactional
public class ThemeDaoJpa implements IThemeDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Theme> findAll() {
			TypedQuery<Theme> query = em.createQuery("select t from Theme t", Theme.class);
			return query.getResultList();
	}

	@Override
	public Theme find(Long id) {
		return em.find(Theme.class, id);
	}

	@Override
	public void create(Theme obj) {
			em.persist(obj);
	}

	@Override
	public Theme update(Theme obj) {
		Theme theme = em.merge(obj);
		return theme;
	}

	@Override
	public void delete(Long id) {
		Theme theme = em.find(Theme.class, id);
			em.remove(theme);
	}
	
}