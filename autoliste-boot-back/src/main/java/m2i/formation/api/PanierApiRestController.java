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

import m2i.formation.dao.IPanierDao;
import m2i.formation.model.Panier;

@RestController
@RequestMapping("/api/panier")
public class PanierApiRestController {
	@Autowired
	private IPanierDao panierDao;

	@GetMapping("")
	public List<Panier> list() {
		List<Panier> paniers = panierDao.findAll();
		return paniers;
	}

	@GetMapping("/{id}")
	public Panier find(@PathVariable Long id) {
		Optional<Panier> optPanier = panierDao.findById(id);

		if (optPanier.isPresent()) {
			return optPanier.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/nom/{nom}")
	public List<Panier> findByNom(@PathVariable String nom) {
		List<Panier> paniers = panierDao.findByNom(nom);

		if (!paniers.isEmpty()) {
			return paniers;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/produit/{id}")
	public List<Panier> findByProduit(@PathVariable long id) {
		List<Panier> paniers = panierDao.findByProduit(id);

		if (!paniers.isEmpty()) {
			return paniers;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Panier create(@RequestBody Panier panier) {
		panier = panierDao.save(panier);

		return panier;
	}

	@PutMapping("/{id}")
	public Panier update(@RequestBody Panier panier, @PathVariable Long id) {
		if (!panierDao.existsById(id) || !id.equals(panier.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		panier = panierDao.save(panier);

		return panier;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!panierDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		panierDao.deleteById(id);

		if (panierDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
