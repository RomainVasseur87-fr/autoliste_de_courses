package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m2i.formation.model.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Long> {
	
	@Query("select c from Categorie c")
	List<Categorie> findAllCategories();

	@Query("select c from Categorie c where c.id = :id")
	Optional<Categorie> findCategorieById(Long id);
		
	@Query("select c from Categorie c where c.nom = :nom")
	List<Categorie> findCategoriesByNom(String nom);

}