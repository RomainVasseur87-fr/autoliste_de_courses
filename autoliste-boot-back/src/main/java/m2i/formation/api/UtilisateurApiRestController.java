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

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Utilisateur;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiRestController {
	@Autowired
	private IUtilisateurDao utilisateurDao;

	@GetMapping("")
	public List<Utilisateur> list() {
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		return utilisateurs;
	}

	@GetMapping("/{id}")
	public Utilisateur find(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/type/{id}")
	public Utilisateur findByType(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurDao.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		if (!utilisateurDao.existsById(id) || !id.equals(utilisateur.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateur = utilisateurDao.save(utilisateur);

		return utilisateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!utilisateurDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateurDao.deleteById(id);

		if (utilisateurDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
