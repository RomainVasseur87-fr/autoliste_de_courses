package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Adresse;

public interface IAdresseDao extends JpaRepository<Adresse, Long> {

}
