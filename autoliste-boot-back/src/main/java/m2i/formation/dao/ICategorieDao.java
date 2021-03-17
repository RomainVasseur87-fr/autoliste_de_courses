package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Categorie;
import m2i.formation.model.Produit;

public interface ICategorieDao extends JpaRepository<Categorie, Long> {
	//@Query("select c from Categorie c")
	//List<Categorie> findAllCategories();
	//@Query("select c from Categorie c where c.id = :id")
	//Optional<Categorie> findById(Long id);
	//@Query("select c from Categorie c where c.id = :id")
	//List<Categorie> findCategoriesById(@Param("id") Long id);
	//@Query("select c from Categorie c where c.nom = :nom")
	//List<Categorie> findCategoriesByNom(String nom);
	//@Query("select p from Produit p join p.categories i where i = :categorie")
	//List<Produit> findProduitsByCategorie(@Param("categorie") Categorie categorie);
	//	List<Categorie> findCategoriesByProduit(Produit produit);
}