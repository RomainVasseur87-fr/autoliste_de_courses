package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Magasin;

public interface IMagasinDao extends JpaRepository<Magasin, Long> {

}
