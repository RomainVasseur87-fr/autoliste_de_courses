package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Long>{

}
