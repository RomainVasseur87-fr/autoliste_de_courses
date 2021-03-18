package m2i.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {
	
	@Query("select u from Utilisateur u left join fetch u.roles where u.username=:username")
	public Optional<Utilisateur> findByIdWithRoles(@Param("username") String username);

	public boolean existsByUsername(String username);
	
}
