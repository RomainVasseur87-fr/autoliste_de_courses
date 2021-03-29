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

import m2i.formation.dao.ICategorieDao;
import m2i.formation.model.Categorie;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/categorie")
public class CategorieApiRestController {

	@Autowired
	private ICategorieDao categorieDao;

	@GetMapping("")
	public List<Categorie> list() {
		List<Categorie> categories = categorieDao.findAll();
		return categories;
	}

	@GetMapping("/{id}")
	public Categorie find(@PathVariable Long id) {
		Optional<Categorie> optCategorie = categorieDao.findById(id);
		if (optCategorie.isPresent()) {
			return optCategorie.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/nom/{nom}")
	public List<Categorie> findCategoriesByNom(@PathVariable String nom) {
		List<Categorie> optCategorie = categorieDao.findCategoriesByNom(nom);
		return optCategorie;
	}
	
	@PostMapping("")
	public Categorie create(@RequestBody Categorie categorie) {
		categorie = categorieDao.save(categorie);
		return categorie;
	}

	@PutMapping("/{id}")
	public Categorie update(@RequestBody Categorie categorie, @PathVariable Long id) {
		if (!categorieDao.existsById(id) || !id.equals(categorie.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		categorie = categorieDao.save(categorie);
		return categorie;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!categorieDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		categorieDao.deleteById(id);
		if (categorieDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}
	
}