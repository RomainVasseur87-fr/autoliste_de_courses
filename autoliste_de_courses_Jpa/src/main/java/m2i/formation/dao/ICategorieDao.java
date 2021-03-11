package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Long> {

}
