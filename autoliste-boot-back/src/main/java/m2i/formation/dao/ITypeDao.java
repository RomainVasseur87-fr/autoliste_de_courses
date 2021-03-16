package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Droit;
import m2i.formation.model.Type;
import m2i.formation.model.Utilisateur;

public interface ITypeDao extends JpaRepository<Type, Long>{
	List<Type> findByDroit(Droit droit);
	
	List<Type> findByUtilisateur(Utilisateur utilisateur);
}
