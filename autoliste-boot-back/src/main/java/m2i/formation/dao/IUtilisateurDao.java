package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, String> {
	
	
	@Query("select u from Utilisateur u where u.nom = :nom")
	List<Utilisateur> findByNom(@Param("nom") String nom);
	
	@Query("select u from Utilisateur u where u.prenom =:prenom")
	List<Utilisateur> findByPrenom(@Param("prenom") String prenom);
	
	@Query("select u from Utilisateur u left join fetch u.adresse where u.adresse.id=:id")
	Optional<Utilisateur> findUtilisateurByAdresse(@Param("id") long id);
	
	@Query("select u from Utilisateur u left join fetch u.recettes rec where rec.id  =:id")
	List<Utilisateur> findByRecette(@Param("id") long id);
	
}
