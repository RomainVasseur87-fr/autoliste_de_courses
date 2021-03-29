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

import m2i.formation.dao.IArticleDao;
import m2i.formation.model.Article;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/article")
public class ArticleApiRestController {
	
	@Autowired
	private IArticleDao articleDao;

	@GetMapping("")
	public List<Article> list() {
		List<Article> articles = articleDao.findAll();
		return articles;
	}
	@GetMapping("/nom/{nom}")
	public List<Article> findByNom(@PathVariable String nom) {
		List<Article> articles = articleDao.findByNom(nom);
		if (!articles.isEmpty()) {
			return articles;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/prix/{prix}")
	public List<Article> findByNom(@PathVariable Double prix) {
		List<Article> articles = articleDao.findByPrix(prix);
		if (!articles.isEmpty()) {
			return articles;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/magasin/{nom}")
	public List<Article> findByMagasinNom(@PathVariable String nom) {
		List<Article> articles = articleDao.findByMagasinNom(nom);
		if (!articles.isEmpty()) {
			return articles;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/prixInf/{prixInf}")
	public List<Article> findByPrixInf(@PathVariable Double prixInf) {
		List<Article> articles = articleDao.findByPrixInf(prixInf);
		if (!articles.isEmpty()) {
			return articles;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/prixSup/{prixSup}")
	public List<Article> findByPrixSup(@PathVariable Double prixSup) {
		List<Article> articles = articleDao.findByPrixSup(prixSup);
		if (!articles.isEmpty()) {
			return articles;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public Article find(@PathVariable Long id) {
		Optional<Article> optArticle = articleDao.findById(id);

		if (optArticle.isPresent()) {
			return optArticle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Article create(@RequestBody Article article) {
		article = articleDao.save(article);

		return article;
	}

	@PutMapping("/{id}")
	public Article update(@RequestBody Article article, @PathVariable Long id) {
		if (!articleDao.existsById(id) || !id.equals(article.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		article = articleDao.save(article);

		return article;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!articleDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		articleDao.deleteById(id);

		if (articleDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}


