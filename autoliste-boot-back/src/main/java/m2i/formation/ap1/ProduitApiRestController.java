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

import m2i.formation.dao.IProduitDao;
import m2i.formation.model.Produit;

@RestController
@RequestMapping("/api/produit")
public class ProduitApiRestController {

	@Autowired
	private IProduitDao produitDao;

	@GetMapping("")
	public List<Produit> list() {
		List<Produit> produits = produitDao.findAll();
		return produits;
	}

	@GetMapping("/{id}")
	public Produit find(@PathVariable Long id) {
		Optional<Produit> optProduit = produitDao.findById(id);

		if (optProduit.isPresent()) {
			return optProduit.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Produit create(@RequestBody Produit produit) {
		produit = produitDao.save(produit);

		return produit;
	}

	@PutMapping("/{id}")
	public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
		if (!produitDao.existsById(id) || !id.equals(produit.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		produit = produitDao.save(produit);

		return produit;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!produitDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		produitDao.deleteById(id);

		if (produitDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
