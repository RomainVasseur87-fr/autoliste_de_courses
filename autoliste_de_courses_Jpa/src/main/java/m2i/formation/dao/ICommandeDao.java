package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Article;
import m2i.formation.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Long> {

	List<Commande> findByArticle(Article article);
	
}
