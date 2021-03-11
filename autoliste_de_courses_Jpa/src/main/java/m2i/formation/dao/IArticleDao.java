package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Article;

public interface IArticleDao extends JpaRepository<Article, Long> {

}
