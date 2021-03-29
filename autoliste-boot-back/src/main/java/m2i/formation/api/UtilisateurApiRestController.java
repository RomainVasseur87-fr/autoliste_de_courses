package m2i.formation.api;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

@CrossOrigin("http://localhost:4200")
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
	public Utilisateur find(@PathVariable String id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/nom/{nom}")
	@JsonView(IViews.IViewUtilisateur.class)
	public List<Utilisateur> findByNom(@PathVariable String nom) {
		List<Utilisateur> utilisateurs = utilisateurDao.findByNom(nom);

		if (!utilisateurs.isEmpty()) {
			return utilisateurs;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/prenom/{prenom}")
	@JsonView(IViews.IViewUtilisateur.class)
	public List<Utilisateur> findByPrenom(@PathVariable String prenom) {
		List<Utilisateur> utilisateurs = utilisateurDao.findByPrenom(prenom);

		if (!utilisateurs.isEmpty()) {
			return utilisateurs;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/recette/{id}")
	@JsonView(IViews.IViewUtilisateur.class)
	public List<Utilisateur> findByRecette(@PathVariable long id) {
		List<Utilisateur> utilisateurs = utilisateurDao.findByRecette(id);

		if (!utilisateurs.isEmpty()) {
			return utilisateurs;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/adresse/{id}")
	public Utilisateur findUtilisateurByAdresse(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurDao.findUtilisateurByAdresse(id);

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

	@PostMapping("/liste")
	public List<Utilisateur> create(@RequestBody List<Utilisateur> utilisateurs) {
		utilisateurs = utilisateurDao.saveAll(utilisateurs);

		return utilisateurs;
	}

	@PutMapping("/{id}")
	@JsonView(IViews.IViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable String id) {
		if (!utilisateurDao.existsById(id) || !id.equals(utilisateur.getId().toString())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateur = utilisateurDao.save(utilisateur);

		return utilisateur;
	}

	@PatchMapping("/{id}")
	@JsonView(IViews.IViewUtilisateur.class)
	public Utilisateur partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable String id) {
		if (!utilisateurDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		final Utilisateur utilisateurFind = utilisateurDao.findById(id).get();

		updates.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Utilisateur.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, utilisateurFind, value);
		});

		Utilisateur utilisateurUpdate = utilisateurDao.save(utilisateurFind);

		return utilisateurUpdate;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		if (!utilisateurDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateurDao.deleteById(id);

		if (utilisateurDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
