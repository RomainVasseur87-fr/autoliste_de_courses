package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Process;

public interface IProcessDao extends JpaRepository<Process, Long> {
	
	@Query("select p from Process p")
	List<Process> findAllProcess();
	
	@Query("select p from Process p where p.id = :id")
	Optional<Process> findProcessById(@Param("id") Long id);
	
	@Query("select p from Process p where p.nom = :nom")
	List<Process> findProcessByNom(@Param("nom") String nom);	
	
	@Query("select p from Process p where p.description = :description")
	List<Process> findProcessByDescription(@Param("description") String description);
		
}