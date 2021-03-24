package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Recette;

public interface IRecetteDao extends JpaRepository<Recette, Long> {
	
	@Query("select r from Recette r where r.nom = :nom")
	List<Recette> findRecettesByNom(@Param("nom") String nom);	
	
	@Query("select r from Recette r left join fetch r.ingredients i where i.id = :id")
	List<Recette> findRecettesByIngredient(@Param("id") Long id);
	
	@Query("select r from Recette r where r.nbConvives = :nbConvives")
	List<Recette> findRecettesByNbConvives(@Param("nbConvives") Long nbConvives);
	
	@Query("select r from Recette r where r.process.id = :id")
	List<Recette> findRecettesByProcess(@Param("id") Long id);
	
	@Query("select r from Recette r where r.nbConvives >= :nbConvives")
	List<Recette> findRecettesByNbConvivesGreaterThan(@Param("nbConvives") Long nbConvives);
	
	@Query("select r from Recette r where r.nbConvives <= :nbConvives")
	List<Recette> findRecettesByNbConvivesSmallerThan(Long nbConvives);
	
	@Query("select r from Recette r left join fetch r.themes i where i.id = :id")
	List<Recette> findRecettesByTheme(Long id); // À tester...
	
	//List<Recette> findRecettesByUtilisateurs(Utilisateur utilisateur);
}