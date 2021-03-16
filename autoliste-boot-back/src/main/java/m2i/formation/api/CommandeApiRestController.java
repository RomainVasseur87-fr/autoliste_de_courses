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

import m2i.formation.dao.ICommandeDao;
import m2i.formation.model.Commande;

@RestController
@RequestMapping("/api/commande")
public class CommandeApiRestController {

	@Autowired
	private ICommandeDao commandeDao;

	@GetMapping("")
	public List<Commande> list() {
		List<Commande> commandes = commandeDao.findAll();
		return commandes;
	}

	@GetMapping("/{id}")
	public Commande find(@PathVariable Long id) {
		Optional<Commande> optCommande = commandeDao.findById(id);

		if (optCommande.isPresent()) {
			return optCommande.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Commande create(@RequestBody Commande commande) {
		commande = commandeDao.save(commande);

		return commande;
	}

	@PutMapping("/{id}")
	public Commande update(@RequestBody Commande commande, @PathVariable Long id) {
		if (!commandeDao.existsById(id) || !id.equals(commande.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		commande = commandeDao.save(commande);

		return commande;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!commandeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		commandeDao.deleteById(id);

		if (commandeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
