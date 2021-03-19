package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Panier;

public interface IPanierDao extends JpaRepository<Panier, Long> {
	
	@Query("select p from Panier p where p.id = :id")
	Panier findById (@Param("id")long id);
	
	@Query("select p from Panier p where p.nom = :nom")
	List<Panier> findByNom (@Param("nom")String nom);
	
	@Query("select p from Panier p left join fetch p.produits pdt where pdt.id = :id")
	List<Panier> findByProduit (@Param("id") long id);
}
