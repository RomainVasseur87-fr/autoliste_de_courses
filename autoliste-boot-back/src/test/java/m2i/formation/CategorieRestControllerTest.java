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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Categorie;

@SpringBootTest
@AutoConfigureMockMvc

class CategorieRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	IProcessDao processDao;

	@Autowired
	IRecetteDao recetteDao;

	@Autowired
	ICategorieDao categorieDao;

	@Autowired
	IThemeDao themeDao;

	@Autowired
	IProduitDao produitDao;

	@Test
	public void categorieGetAll() throws Exception {
		mockMvc.perform(get("/api/categorie")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// ==========
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	// ==========

	@Test
	public void getCategorieById() throws Exception {
		Categorie categorie = new Categorie("Boisson");
		categorie = categorieDao.save(categorie);

		mockMvc.perform(get("/api/categorie/" + categorie.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Boisson"));
	}

	@Test
	public void categorieGetByNom() throws Exception {
		Categorie categorie = new Categorie();
		categorie.setNom("Boisson");
		categorie = categorieDao.save(categorie);

		mockMvc.perform(get("/api/categorie/nom/Boisson").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Boisson"));
	}

	@Test
	public void categorieDelete() throws Exception {
		Categorie categorie = new Categorie();
		categorie.setNom("Cat");
		categorie = categorieDao.save(categorie);
		mockMvc.perform(delete("/api/categorie/{id}", categorie.getId())).andExpect(status().isOk());
	}

	@Test
	public void categoriePost() throws Exception {
		Categorie categorie = new Categorie("Catégorie-123456789-123456789");
		ObjectMapper mapper = new ObjectMapper();
		String jsonCategorie = mapper.writeValueAsString(categorie);
		mockMvc.perform(post("/api/categorie").contentType(MediaType.APPLICATION_JSON).content(jsonCategorie))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Catégorie-123456789-123456789")).andDo(print())
				.andExpect(jsonPath("$.version").value(0));
	}

	@Test
	public void categoriePut() throws Exception {
		String nom = "Catégorie " + Math.random();
		Categorie categorie = new Categorie();
		categorie.setNom(nom);
		categorie = categorieDao.save(categorie);

		ObjectMapper mapper = new ObjectMapper();
		String jsonCategorie = mapper.writeValueAsString(categorie);

		mockMvc.perform(put("/api/categorie/" + categorie.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(jsonCategorie)).andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.id", is(notNullValue()))).andExpect(jsonPath("$.nom").value(nom));
	}

}