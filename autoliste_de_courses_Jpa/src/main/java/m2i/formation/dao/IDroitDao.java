package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Droit;

public interface IDroitDao extends JpaRepository<Droit, Long> {

}
