package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Long>{
	
	@Query("select p from Produit p where p.id = :id")
	Produit findById(@Param("id")long id);
	
	@Query("select p from Produit p where p.nom = :nom")
	List<Produit> findByNom(@Param("nom")String nom);
	
	@Query("select p from Produit p left join fetch p.categories cat where cat.id = :id")
	List<Produit> findByCategorie(@Param("id")long id);
	
}
