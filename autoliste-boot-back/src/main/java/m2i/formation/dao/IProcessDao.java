package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Process;
import m2i.formation.model.Recette;

public interface IProcessDao extends JpaRepository<Process, Long> {
	
	@Query("select p from Process p")
	List<Process> findAllProcess(); // OK.
	
	@Query("select p from Process p where p.id = :id")
	Optional<Process> findProcessById(@Param("id") Long id); // OK.
	
	@Query("select p from Process p where p.description = :description")
	Optional<Process> findProcessByDescription(@Param("description") String description); // OK. Mieux vaut mettre List ?
	
	@Query("select p from Process p where p.nom = :nom")
	Optional<Process> findProcessByNom(@Param("nom") String nom); // OK. Mieux vaut mettre List ?
	
	@Query("select r from Recette r where r.process = :process")
	Recette findRecetteByProcess(@Param("process") Process process); // OK.
	
//	Process findProcessByRecette(Recette recette);
}