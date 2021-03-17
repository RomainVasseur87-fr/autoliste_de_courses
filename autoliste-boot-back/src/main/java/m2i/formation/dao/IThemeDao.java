package m2i.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Recette;
import m2i.formation.model.Theme;

public interface IThemeDao extends JpaRepository<Theme, Long> {
	//@Query("select t from Theme t")
	//List<Theme> findAllThemes();
	//@Query("select t from Theme t where t.id = :id")
	//Optional<Theme> findThemesById(@Param("id") Long id);
	//@Query("select t from Theme t where t.nom = :nom")
	//List<Theme> findThemesByNom(String nom);
	//@Query("select r from Recette r join r.themes i where i = :theme")
	//List<Recette> findRecettesByTheme(@Param("theme") Theme theme);
	//	List<Theme> findThemesByRecette(Recette recette);
}