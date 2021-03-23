package m2i.formation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Categorie;
import m2i.formation.model.Process;
import m2i.formation.model.Recette;

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
	@WithUserDetails("mohamed")
	public void categorieGetAll() throws Exception {
		mockMvc.perform(get("/api/categorie")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	//========== https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/ ==========
	
	@Test
	@WithUserDetails("mohamed")
	public void getCategorieById() throws Exception {
		List<Categorie> categories = categorieDao.findAll();
		Long id = categories.get(0).getId();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/categorie/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
	}
	
	@Test
	@WithUserDetails("mohamed")
	public void categorieGetByNom() throws Exception {
		Categorie categorie = new Categorie();
		categorie.setNom("Boisson");
		categorie = categorieDao.save(categorie);

		mockMvc.perform(get("/api/categorie/nom/Boisson").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$[0].nom").value("Boisson"));
	}
	
	@Test
	@WithUserDetails("mohamed")
	public void categorieDelete() throws Exception {
		Categorie categorie = new Categorie();
		categorie.setNom("Cat");
		categorie = categorieDao.save(categorie);
		mockMvc.perform(delete("/api/categorie/{id}", categorie.getId())).andExpect(status().isOk());
	}

	
	@Test
	@WithUserDetails("mohamed")
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
	@WithUserDetails("mohamed")
	public void categoriePut() throws Exception {
		String nom = "Catégorie " + Math.random();
		Categorie categorie = new Categorie();
		categorie.setNom(nom);
		categorie = categorieDao.save(categorie);

		ObjectMapper mapper = new ObjectMapper();
		String jsonCategorie = mapper.writeValueAsString(categorie);

		mockMvc.perform(
				put("/api/categorie/" + categorie.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonCategorie))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value(nom));
	}
	
}