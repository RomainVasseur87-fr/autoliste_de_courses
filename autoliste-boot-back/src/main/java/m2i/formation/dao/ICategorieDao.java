package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Categorie;
import m2i.formation.model.Produit;

public interface ICategorieDao extends JpaRepository<Categorie, Long> {
	
	@Query("select c from Categorie c")
	List<Categorie> findAllCategories(); // OK.

	@Query("select c from Categorie c where c.id = :id")
	Optional<Categorie> findCategorieById(Long id); // OK. Mieux vaut mettre List ?
		
	@Query("select c from Categorie c where c.nom = :nom")
	Optional<Categorie> findCategoriesByNom(String nom); // OK. Mieux vaut mettre List ?

	@Query("select p from Produit p left join fetch p.categories i where i.id = :id")
	List<Produit> findProduitsByCategorie(@Param("id") Long id); // OK.

	//	List<Categorie> findCategoriesByProduit(Produit produit);
}