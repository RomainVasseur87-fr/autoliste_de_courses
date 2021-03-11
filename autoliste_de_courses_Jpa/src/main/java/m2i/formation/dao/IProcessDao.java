package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Process;

public interface IProcessDao extends JpaRepository<Process, Long> {

}
