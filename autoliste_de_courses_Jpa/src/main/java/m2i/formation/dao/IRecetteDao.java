package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Recette;

public interface IRecetteDao extends JpaRepository<Recette, Long> {

}
