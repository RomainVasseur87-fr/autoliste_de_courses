package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Panier;

public interface IPanierDao extends JpaRepository<Panier, Long> {

}
