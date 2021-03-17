package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Produit;
import m2i.formation.model.Recette;

public interface IRecetteDao extends JpaRepository<Recette, Long> {
	//@Query("select r from Recette r join r.ingredients i where i = :ingredient")
	//List<Recette> findRecettesByIngredient(@Param("ingredient") Produit ingredient);
	//@Query("select r from Recette r where r.nbConvives = :nbConvives")
	//List<Recette> findRecettesByNbConvives(@Param("nbConvives") Long nbConvives);
	//@Query("select r from Recette r where r.process = :process")
	//Recette findRecetteByProcess(@Param("process") Process process);
	//@Query("select r from Recette r where r.nbConvives > :nbConvives")
	//List<Recette> findRecettesByNbConvivesGreaterThan(@Param("nbConvives") Long nbConvives);
	//@Query("select r from Recette r where r.nbConvives < :nbConvives")
	//List<Recette> findRecettesByNbConvivesSmallerThan(Long nbConvives);
	//	List<Utilisateur> findUtilisateursByRecette(Recette recette);
	//	List<Recette> findRecettesByUtilisateurs(Utilisateur utilisateur);
}