package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Adresse;
import m2i.formation.model.Type;
import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {
//	List<Utilisateur> findByType(Type type);
//
//	List<Utilisateur> findByAdresse(Adresse adresse);
//	
//	List<Utilisateur> findByNom(String nom);
//	
//	List<Utilisateur> findByEmail(String email);
	
}
