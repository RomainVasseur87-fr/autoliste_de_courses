package m2i.formation.ap1;

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

import m2i.formation.dao.IDroitDao;
import m2i.formation.model.Droit;

@RestController
@RequestMapping("/api/droit")
public class DroitApiRestController {
	@Autowired
	private IDroitDao droitDao;

	@GetMapping("")
	public List<Droit> list() {
		List<Droit> droits = droitDao.findAll();
		return droits;
	}

	@GetMapping("/{id}")
	public Droit find(@PathVariable Long id) {
		Optional<Droit> optDroit = droitDao.findById(id);

		if (optDroit.isPresent()) {
			return optDroit.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Droit create(@RequestBody Droit droit) {
		droit = droitDao.save(droit);

		return droit;
	}

	@PutMapping("/{id}")
	public Droit update(@RequestBody Droit droit, @PathVariable Long id) {
		if (!droitDao.existsById(id) || !id.equals(droit.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		droit = droitDao.save(droit);

		return droit;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!droitDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		droitDao.deleteById(id);

		if (droitDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
