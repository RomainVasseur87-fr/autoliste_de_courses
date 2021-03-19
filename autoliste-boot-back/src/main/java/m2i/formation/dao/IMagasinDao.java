package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import m2i.formation.model.Magasin;

public interface IMagasinDao extends JpaRepository<Magasin, Long> {
	
	//besoin du nom exacte
	@Query("select m from Magasin m where m.nom = :nom")
	List<Magasin> findByNom (@Param("nom")String nom);
	
	//besoin d'un mot du nom (mettre % dans l'appel de la fonction)
	@Query("select m from Magasin m where m.nom like :nom")
	List<Magasin> findByPartieNom (@Param("nom")String nom);
	
	@Query("select m from Magasin m left join fetch m.adresse where m.adresse.id = :id")
	Magasin findByAdresse (@Param("id") Long id);
	
	@Query("select m from Magasin m left join fetch m.adresse where m.adresse.ville = :ville")
	List<Magasin> findByVille (@Param("ville")String ville);
	
	

}
