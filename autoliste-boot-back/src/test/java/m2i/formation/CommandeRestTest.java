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

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import m2i.formation.dao.IArticleDao;
import m2i.formation.dao.ICommandeDao;
import m2i.formation.model.Article;
import m2i.formation.model.Commande;

@SpringBootTest
@AutoConfigureMockMvc
public class CommandeRestTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ICommandeDao commandeDao;
	@Autowired
	private IArticleDao articleDao;

	@Test
	public void commandeGet() throws Exception {
		mockMvc.perform(get("/api/commande")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void commandeGetFindById() throws Exception {
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, null);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzanni", (long) 1000, 1.03, null);
		article2 = articleDao.save(article2);
		List<Article> articles = List.of(article1, article2);
		Commande commande = new Commande("commandeDuLundi", articles);
		commande = commandeDao.save(commande);

		mockMvc.perform(get("/api/commande/" + commande.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("commandeDuLundi"))
				.andExpect(jsonPath("$.articles[0].id").value(article1.getId()))
				.andExpect(jsonPath("$.articles[1].id").value(article2.getId()));
	}

	@Test
	public void commandePost() throws Exception {
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, null);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzanni", (long) 1000, 1.03, null);
		article2 = articleDao.save(article2);
		List<Article> articles = List.of(article1, article2);
		Commande commande = new Commande("commandeDuLundi", articles);

		ObjectMapper mapper = new ObjectMapper();
		String jsonCommande = mapper.writeValueAsString(commande);

		mockMvc.perform(post("/api/commande").contentType(MediaType.APPLICATION_JSON).content(jsonCommande))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("commandeDuLundi"))
				.andExpect(jsonPath("$.articles[0].id").value(article1.getId()))
				.andExpect(jsonPath("$.articles[1].id").value(article2.getId()));

	}

	@Test
	public void commandeGetFindByNom() throws Exception {
		int sizeStart = commandeDao.findByNom("commandeDuLundi").size();
		Commande commande = new Commande("commandeDuLundi", null);
		commande = commandeDao.save(commande);

		mockMvc.perform(get("/api/commande/nom/" + commande.getNom()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(sizeStart + 1));

	}

	@Test
	public void articlePut() throws Exception {
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, null);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzanni", (long) 1000, 1.03, null);
		article2 = articleDao.save(article2);
		List<Article> articles = List.of(article1, article2);
		Commande commande = new Commande("commandeDuLundi", articles);
		commande = commandeDao.save(commande);

		ObjectMapper mapper = new ObjectMapper();
		String jsonCommande = mapper.writeValueAsString(commande);

		mockMvc.perform(
				put("/api/commande/" + commande.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonCommande))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("commandeDuLundi"))
				.andExpect(jsonPath("$.articles[0].id").value(article1.getId()))
				.andExpect(jsonPath("$.articles[1].id").value(article2.getId()));
	}

	@Test
	public void CommandeDelete() throws Exception {
		Article article1 = new Article("pate lustucru", (long) 1000, 0.98, null);
		article1 = articleDao.save(article1);
		Article article2 = new Article("pate panzanni", (long) 1000, 1.03, null);
		article2 = articleDao.save(article2);
		List<Article> articles = List.of(article1, article2);
		Commande commande = new Commande("commandeDuLundi", articles);
		commande = commandeDao.save(commande);

		int sizeStart = commandeDao.findAll().size();

		mockMvc.perform(delete("/api/commande/" + commande.getId())).andExpect(status().isOk());

		int endSize = commandeDao.findAll().size();
		Assertions.assertEquals(-1, endSize - sizeStart);
	}

}
