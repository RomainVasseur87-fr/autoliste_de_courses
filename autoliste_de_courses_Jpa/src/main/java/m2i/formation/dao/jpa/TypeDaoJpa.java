package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import m2i.formation.dao.ITypeDao;
import m2i.formation.model.Type;

@Repository
@Transactional
public class TypeDaoJpa implements ITypeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Type> findAll() {
		
		List<Type> types = new ArrayList<Type>();
		TypedQuery<Type> query = em.createQuery("select t from Type t", Type.class);
		return types = query.getResultList();
		
	}

	@Override
	public Type find(Long id) {
		
		Type type = null;
		return type = em.find(Type.class, id);

	}

	@Override
	public void create(Type obj) {

		em.persist(obj);

	}

	@Override
	public Type update(Type obj) {
		
		Type type = null;
		return type = em.merge(obj);

	}

	@Override
	public void delete(Long id) {
		
		Type type = em.find(Type.class, id);
		em.remove(type);

	}
}
