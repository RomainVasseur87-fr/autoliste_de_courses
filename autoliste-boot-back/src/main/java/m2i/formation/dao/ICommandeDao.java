package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m2i.formation.model.Article;
import m2i.formation.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Long> {

	//@Query("select c from Commande c left join fetch c.articles ")
	//List<Commande> findByArticle(Article article);
	
}
