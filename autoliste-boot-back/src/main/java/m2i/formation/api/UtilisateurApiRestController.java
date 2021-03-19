package m2i.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.IViews;
import m2i.formation.model.Utilisateur;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiRestController {
	@Autowired
	private IUtilisateurDao utilisateurDao;

	@GetMapping("")
	@JsonView(IViews.IViewUtilisateur.class)
	public List<Utilisateur> list() {
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		return utilisateurs;
	}
	

	@GetMapping("/{id}")
	@JsonView(IViews.IViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(IViews.IViewUtilisateurDetail.class)
	public Utilisateur detail(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping("")
	@JsonView(IViews.IViewUtilisateur.class)
	@PreAuthorize("hasRole('ADMIN')")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurDao.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/{username}")
	@JsonView(IViews.IViewUtilisateur.class)
	@PreAuthorize("hasRole('ADMIN')")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable String username) {
		if (!utilisateurDao.existsByUsername(username) || !username.equals(utilisateur.getUsername())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateur = utilisateurDao.save(utilisateur);

		return utilisateur;
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
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
