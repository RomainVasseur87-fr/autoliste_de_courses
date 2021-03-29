package m2i.formation;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.IMagasinDao;
import m2i.formation.model.Article;
import m2i.formation.model.Magasin;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleRestTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private IArticleDao articleDao;
	@Autowired
	private IMagasinDao magasinDao;

	@Test
	public void articleGet() throws Exception {
		mockMvc.perform(get("/api/article")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void articleGetFindById() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		mockMvc.perform(get("/api/article/" + article.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("pate lustucru"))
				.andExpect(jsonPath("$.conditionement").value((long) 1000)).andExpect(jsonPath("$.prix").value(0.98))
				.andExpect(jsonPath("$.magasin").value(magasin));

	}

	@Test
	public void articlePost() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);

		ObjectMapper mapper = new ObjectMapper();
		String jsonArticle = mapper.writeValueAsString(article);

		mockMvc.perform(post("/api/article").contentType(MediaType.APPLICATION_JSON).content(jsonArticle))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("pate lustucru"))
				.andExpect(jsonPath("$.conditionement").value((long) 1000)).andExpect(jsonPath("$.prix").value(0.98))
				.andExpect(jsonPath("$.magasin").value(magasin));

	}

	@Test
	public void articleGetFindByNom() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int sizeStart = articleDao.findByNom("pate lustucru").size();
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		mockMvc.perform(get("/api/article/nom/" + article.getNom()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));

	}

	@Test
	public void articleGetFindByPrix() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int sizeStart = articleDao.findByPrix(0.98).size();
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		mockMvc.perform(get("/api/article/prix/" + article.getPrix()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void articleGetFindByPrixInf() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int sizeStart = articleDao.findByPrixInf(1.0).size();
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzani", (long) 1000, 1.03, magasin);
		article2 = articleDao.save(article2);

		mockMvc.perform(get("/api/article/prixInf/1.0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void articleGetFindByPrixSup() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int sizeStart = articleDao.findByPrixSup(1.0).size();
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzani", (long) 1000, 1.03, magasin);
		article2 = articleDao.save(article2);

		mockMvc.perform(get("/api/article/prixSup/1.0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void articleGetFindByMagasin() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		int sizeStart = articleDao.findByMagasinNom("auchan").size();
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		mockMvc.perform(get("/api/article/magasin/" + magasin.getNom()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));

	}

	@Test
	public void articlePut() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);
		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		ObjectMapper mapper = new ObjectMapper();
		String jsonArticle = mapper.writeValueAsString(article);

		mockMvc.perform(
				put("/api/article/" + article.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonArticle))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("pate lustucru"))
				.andExpect(jsonPath("$.conditionement").value((long) 1000)).andExpect(jsonPath("$.prix").value(0.98))
				.andExpect(jsonPath("$.magasin").value(magasin));

	}

	@Test
	public void articleDelete() throws Exception {
		Magasin magasin = new Magasin("auchan", null);
		magasin = magasinDao.save(magasin);

		Article article = new Article("pate lustucru", (long) 1000, 0.98, magasin);
		article = articleDao.save(article);

		int sizeStart = articleDao.findAll().size();

		mockMvc.perform(delete("/api/article/" + article.getId())).andExpect(status().isOk());

		int endSize = articleDao.findAll().size();
		Assertions.assertEquals(-1, endSize - sizeStart);
	}

}
