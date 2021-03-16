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

import m2i.formation.dao.IArticleDao;
import m2i.formation.model.Article;

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


