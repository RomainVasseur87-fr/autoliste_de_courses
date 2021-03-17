package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Adresse;
import m2i.formation.model.Magasin;

public interface IMagasinDao extends JpaRepository<Magasin, Long> {
	
	//besoin du nom exacte
	//List<Magasin> findByNom (String nom);
	//besoin d'un mot du nom (mettre % dans l'appel de la fonction)
	//@Query("select m from magasin m where m.nom like :nom")
	//List<Magasin> findByPartieNom (@Param("nom")String nom);
	
	//Magasin findByAdresse (Adresse adresse);

}
