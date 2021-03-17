package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Droit;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes

public interface IDroitDao extends JpaRepository<Droit, Long> {
	
	//List<Droit> findByCanCreate(Boolean canCreate);
	
	//List<Droit> findByCanRead(Boolean canRead);
	
	//List<Droit> findByCanUpdate(Boolean canUpdate);
	
	//List<Droit> findByCanDelete(Boolean canDelete);

}
