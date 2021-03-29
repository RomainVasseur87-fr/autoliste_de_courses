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

import m2i.formation.dao.IMagasinDao;
import m2i.formation.model.Magasin;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/magasin")
public class MagasinApiRestController {
	@Autowired
	private IMagasinDao magasinDao;

	@GetMapping("")
	public List<Magasin> list() {
		List<Magasin> magasins = magasinDao.findAll();
		return magasins;
	}
	@GetMapping("/nom/{nom}")
	public List<Magasin> findByNom(@PathVariable String nom) {
		List<Magasin> magasins = magasinDao.findByNom(nom);

		if (!magasins.isEmpty()) {
			return magasins;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/partienom/{nom}")
	public List<Magasin> findByPartieNom(@PathVariable String nom) {
		List<Magasin> magasins = magasinDao.findByPartieNom(nom);

		if (!magasins.isEmpty()) {
			return magasins;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/adresse/{id}")
	public Magasin findByAdresse(@PathVariable Long id) {
		Optional<Magasin> optMagasin = magasinDao.findMagasinByAdresse(id);

		if (optMagasin.isPresent()) {
			return optMagasin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/ville/{ville}")
	public List<Magasin> findByVille(@PathVariable String ville) {
		List<Magasin> magasins = magasinDao.findByVille(ville);

		if (!magasins.isEmpty()) {
			return magasins;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public Magasin find(@PathVariable Long id) {
		Optional<Magasin> optMagasin = magasinDao.findById(id);

		if (optMagasin.isPresent()) {
			return optMagasin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Magasin create(@RequestBody Magasin magasin) {
		magasin = magasinDao.save(magasin);

		return magasin;
	}

	@PutMapping("/{id}")
	public Magasin update(@RequestBody Magasin magasin, @PathVariable Long id) {
		if (!magasinDao.existsById(id) || !id.equals(magasin.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		magasin = magasinDao.save(magasin);

		return magasin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!magasinDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		magasinDao.deleteById(id);

		if (magasinDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}