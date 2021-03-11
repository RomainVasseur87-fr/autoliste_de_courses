package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Theme;

public interface IThemeDao extends JpaRepository<Theme, Long> {

}
