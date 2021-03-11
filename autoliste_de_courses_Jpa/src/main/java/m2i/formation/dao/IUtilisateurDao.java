package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {

}
