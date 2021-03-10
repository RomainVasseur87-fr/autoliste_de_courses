package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IProcessDao;

@Repository
@Transactional
public class ProcessDaoJpa implements IProcessDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Process> findAll() {
			TypedQuery<Process> query = em.createQuery("select p from Process p", Process.class);
			return query.getResultList();
	}

	@Override
	public Process find(Long id) {
			return em.find(Process.class, id);
	}

	@Override
	public void create(Process obj) {
			em.persist(obj);
	}

	@Override
	public Process update(Process obj) {
		Process process = em.merge(obj);
		return process;
	}

	@Override
	public void delete(Long id) {
			Process process = em.find(Process.class, id);
			em.remove(process);
	}
	
}