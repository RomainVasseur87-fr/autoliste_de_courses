package m2i.formation.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import m2i.formation.model.Type;


public interface ITypeDao extends JpaRepository<Type, Long>{
	
}
