package m2i.formation.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import m2i.formation.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Long> {

	//@Query("select c from Commande c left join fetch c.articles ")
	//List<Commande> findByArticle(Article article);
	
}
