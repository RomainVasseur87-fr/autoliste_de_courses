package m2i.formation.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Long> {
	
	@Query("select c from Commande c left join fetch c.articles where c.id = :id")
	Optional<Commande> findCommandeById(@Param("id")long id);
	
	@Query("select c from Commande c where c.nom = :nom")
	List<Commande> findByNom(@Param("nom")String nom);
	
	@Query("select c from Commande c left join fetch c.articles art where art.id = :id ")
	List<Commande> findByArticle(@Param("id")long id);
	
}
