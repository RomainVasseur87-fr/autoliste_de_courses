package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Adresse;

public interface IAdresseDao extends JpaRepository<Adresse, Long> {
	
	
	List<Adresse> findByVille(String ville);
	
	List<Adresse> findByCodePostal(String codePostal);
	
	@Query("select u.adresse from Utilisateur u where u.id = :id")
	Adresse findByUtilisateur (@Param("id") long id);
	
	
}