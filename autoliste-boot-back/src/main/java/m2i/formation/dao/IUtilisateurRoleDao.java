package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Role;
import m2i.formation.model.Utilisateur;
import m2i.formation.model.UtilisateurRole;

public interface IUtilisateurRoleDao extends JpaRepository<UtilisateurRole, Role>{

	@Query("select r.user from UtilisateurRole r where r.role=:role")
	public List<Utilisateur> findByRole(@Param("role") Role role);

	
	}

