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
import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/adresse")
public class AdresseApiRestController {

	@Autowired
	private IAdresseDao adresseDao;

	@GetMapping("")
	public List<Adresse> list() {
		List<Adresse> adresses = adresseDao.findAll();
		return adresses;
	}
	
	@GetMapping("/ville/{ville}")
	public List<Adresse> findByVille(@PathVariable String ville){
		List<Adresse> adresses = adresseDao.findByVille(ville);
		return adresses;
	}
	@GetMapping("/codepostal/{codePostal}")
	public List<Adresse> findByCodePostal(@PathVariable String codePostal){
		List<Adresse> adresses = adresseDao.findByCodePostal(codePostal);
		return adresses;
	}
	@GetMapping("/utilisateur/{id}")
	public Adresse findByUtilisateur(@PathVariable long id){
		Adresse adresse = adresseDao.findByUtilisateur(id);
		return adresse;
	}

	@GetMapping("/{id}")
	public Adresse find(@PathVariable Long id) {
		Optional<Adresse> optAdresse = adresseDao.findById(id);

		if (optAdresse.isPresent()) {
			return optAdresse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Adresse create(@RequestBody Adresse adresse) {
		adresse = adresseDao.save(adresse);

		return adresse;
	}

	@PutMapping("/{id}")
	public Adresse update(@RequestBody Adresse adresse, @PathVariable Long id) {
		if (!adresseDao.existsById(id) || !id.equals(adresse.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		adresse = adresseDao.save(adresse);

		return adresse;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!adresseDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		adresseDao.deleteById(id);

		if (adresseDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
