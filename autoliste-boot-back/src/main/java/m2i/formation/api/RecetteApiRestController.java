package m2i.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.formation.dao.IRecetteDao;
import m2i.formation.model.Recette;

@RestController
@RequestMapping("/api/recette")
public class RecetteApiRestController {

	@Autowired
	private IRecetteDao recetteDao;

	@GetMapping("")
	public List<Recette> list() {
		List<Recette> recettes = recetteDao.findAll();
		return recettes;
	}

	@GetMapping("/{id}")
	public Recette find(@PathVariable Long id) {
		Optional<Recette> optRecette = recetteDao.findById(id);
		if (optRecette.isPresent()) {
			return optRecette.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Recette create(@RequestBody Recette recette) {
		recette = recetteDao.save(recette);
		return recette;
	}

	@PutMapping("/{id}")
	public Recette update(@RequestBody Recette recette, @PathVariable Long id) {
		if (!recetteDao.existsById(id) || !id.equals(recette.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		recette = recetteDao.save(recette);
		return recette;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!recetteDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		recetteDao.deleteById(id);
		if (recetteDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}
	
}