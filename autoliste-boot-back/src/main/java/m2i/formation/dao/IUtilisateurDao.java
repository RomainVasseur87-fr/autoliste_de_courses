package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Adresse;
import m2i.formation.model.Recette;
import m2i.formation.model.Type;
import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {
	//List<Utilisateur> findByType(Type type);

	//List<Utilisateur> findByAdresse(Adresse adresse);
	
	//List<Utilisateur> findByNom(String nom);
	
	//List<Utilisateur> findByEmail(String email);
	
	@Query("select u.utilisateur from Type t where t.id = :id")
	Utilisateur findByType (@Param("id") long id);
	
	@Query("select ur.recette from utilisateurs_recettes ur where ur.utilisateur_id = :id")
	List<Recette> findRecettesByUtilisateur (@Param("id") long id);
	
}
