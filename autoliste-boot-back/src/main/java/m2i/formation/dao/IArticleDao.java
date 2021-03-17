package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Article;

public interface IArticleDao extends JpaRepository<Article, Long> {
	
	@Query("select a from Article a where a.nom =:nom ")
	List<Article> findByNom (@Param("nom")String nom);
	
	@Query("select a from Article a where a.prix =:prix")
	List<Article> findByPrix (@Param("prix") Double prix);
	
	@Query("select a from Article a where a.magasin.nom = :nom")
	List<Article> findByMagasinNom (@Param("nom") String nom);
	
	@Query("select a from Article a where a.prix <= :prixInf")
	List<Article> findByPrixInf (@Param("prixInf") Double prixInf);
	
	@Query("select a from Article a where a.prix >= :prixSup")
	List<Article> findByPrixSup (@Param("prixSup") Double prixSup);
	
	

}
