package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, String> {
	
	
	@Query("select u from Utilisateur u where u.username =:username")
	List<Utilisateur> findByUsername(@Param("username") String username);
	
	@Query("select u from Utilisateur u where u.enable =:enable")
	List<Utilisateur> findByEnable(@Param("enable") boolean enable);
	
	@Query("select u from Utilisateur u left join fetch u.roles where u.username=:username")
	public Optional<Utilisateur> findByIdWithRoles(@Param("username") String username);
	
	public boolean existsByUsername(String username);
	
}
