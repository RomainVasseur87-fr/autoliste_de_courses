package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Adresse;
import m2i.formation.model.Utilisateur;

public interface IAdresseDao extends JpaRepository<Adresse, Long> {
	
	@Query("select a from Adresse a where a.ville =:ville")
	List<Adresse> findByVille(@Param("ville")String ville);
	
	@Query("select a from Adresse a where a.codePostal = :codePostal")
	List<Adresse> findByCodePostal(@Param("codePostal")String codePostal);

	@Query("select u.adresse from Utilisateur u where u.id = :id")
	Adresse findByUtilisateur(@Param("id") long id);

=======
	List<Adresse> findByVille(String ville);
	
	List<Adresse> findByCodePostal(String codePostal);
	
	@Query("select u.utilisateur from Type t where t.id = :id")
	Utilisateur findByType (@Param("id") long id);
	
>>>>>>> Stashed changes
}