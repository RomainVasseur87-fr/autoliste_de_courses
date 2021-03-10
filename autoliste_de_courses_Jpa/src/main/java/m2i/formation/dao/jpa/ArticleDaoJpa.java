package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IArticleDao;
import m2i.formation.model.Article;

@Repository
@Transactional
public class ArticleDaoJpa implements IArticleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Article> findAll() {
		List<Article> articles = null;

		TypedQuery<Article> myQuery = em.createQuery("select art from Article art", Article.class);
		articles = myQuery.getResultList();

		return articles;
	}

	@Override
	public Article find(Long id) {
		Article article = null;

		article = em.find(Article.class, id);

		return article;
	}

	@Override
	public void create(Article obj) {

		em.persist(obj);

	}

	@Override
	public Article update(Article obj) {
		Article article = null;

		article = em.merge(obj);

		return article;
	}

	@Override
	public void delete(Long id) {

		Article article = em.find(Article.class, id);
		em.remove(article);

	}

}
