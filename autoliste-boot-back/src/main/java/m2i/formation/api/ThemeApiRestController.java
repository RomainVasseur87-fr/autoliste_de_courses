package m2i.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Theme;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/theme")
public class ThemeApiRestController {

	@Autowired
	private IThemeDao themeDao;

	@GetMapping("")
	public List<Theme> list() {
		List<Theme> themes = themeDao.findAll();
		return themes;
	}

	@GetMapping("/{id}")
	public Theme find(@PathVariable Long id) {
		Optional<Theme> optTheme = themeDao.findThemeById(id);
		if (optTheme.isPresent()) {
			return optTheme.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	// Modifications : Le 31/03/2021.
	
	@GetMapping("/nom/{nom}")
	public Theme findThemeByNom(@PathVariable String nom) {
		Optional<Theme> optTheme = themeDao.findThemeByNom(nom);
		if (optTheme.isPresent()) {
			return optTheme.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	// Modifications : Le 31/03/2021.
	
	@PostMapping("")
	public Theme create(@RequestBody Theme theme) {
		Optional<Theme> optTheme = themeDao.findThemeByNom(theme.getNom());
		if (optTheme.isPresent()) {
			return optTheme.get();
		} else {
			theme = themeDao.save(theme);
			return theme;
		}
	}

	@PutMapping("/{id}")
	public Theme update(@RequestBody Theme theme, @PathVariable Long id) {
		if (!themeDao.existsById(id) || !id.equals(theme.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		theme = themeDao.save(theme);
		return theme;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!themeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		themeDao.deleteById(id);
		if (themeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}