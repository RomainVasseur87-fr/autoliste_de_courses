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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Produit;
import m2i.formation.model.Recette;
import m2i.formation.model.Theme;

@SpringBootTest
@AutoConfigureMockMvc

class RecetteRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	IRecetteDao recetteDao;

	@Autowired
	IThemeDao themeDao;

	@Autowired
	IProcessDao processDao;

	@Autowired
	IProduitDao produitDao;

	@Test
	public void recetteGetAll() throws Exception {
		List<Recette> recettes = recetteDao.findAll();
		int sizeStart = recettes.size();
		Recette recette = new Recette();
		recette = recetteDao.save(recette);

		mockMvc.perform(get("/api/recette")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	// ===========================================================================
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	// ===========================================================================

	@Test
	public void recetteGetById() throws Exception {
		List<Recette> recettes = recetteDao.findAll();
		Long id = recettes.get(0).getId();

		mockMvc.perform(MockMvcRequestBuilders.get("/api/recette/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
	}

	// ===========================================================================
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	// ===========================================================================

	@Test
	public void recetteGetByNom() throws Exception {
		Recette recette = new Recette();
		recette.setNom("Chips");
		recette.setnbConvives(2L);
		recette = recetteDao.save(recette);

		mockMvc.perform(get("/api/recette/nom/Chips").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$[0].nom").value("Chips"));
	}

	@Test
	public void recetteGetByTheme() throws Exception {
		Theme theme1 = new Theme("AAAAA1");
		theme1 = themeDao.save(theme1);
		Theme theme2 = new Theme("BBBBB2");
		theme2 = themeDao.save(theme2);
		Theme theme3 = new Theme("CCCCC3");
		theme3 = themeDao.save(theme3);
		Theme theme4 = new Theme("DDDDD4");
		theme4 = themeDao.save(theme4);
		Theme theme5 = new Theme("EEEEE5");
		theme5 = themeDao.save(theme5);

		Recette recette;
		recette = new Recette();
		recette.setNom("Recette 1234567890");
		recette.setThemes(List.of(theme1, theme2, theme3, theme4, theme5));

		recette = recetteDao.save(recette);

		int nombre = recetteDao.findRecettesByTheme(theme1.getId()).size();

		mockMvc.perform(get("/api/recette/theme/{id}", theme1.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(nombre));
	}

	@Test
	public void recetteDelete() throws Exception {
		Recette recette = new Recette();
		recette.setNom("Chips");
		recette.setnbConvives(2L);
		recette = recetteDao.save(recette);
		mockMvc.perform(delete("/api/recette/{id}", recette.getId())).andExpect(status().isOk());
	}

	@Test
	public void recettePost() throws Exception {
		Recette recette = new Recette();
		recette.setNom("Recette 1");
		recette.setnbConvives(2L);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(post("/api/recette").contentType(MediaType.APPLICATION_JSON).content(jsonRecette))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Recette 1")).andDo(print())
				.andExpect(jsonPath("$.version").value(0));
	}

	@Test
	public void recettePut() throws Exception {

		Recette recette = new Recette();
		recette.setNom("Recette 123456");
		recette.setnbConvives(8L);
		recette = recetteDao.save(recette);

		ObjectMapper mapper = new ObjectMapper();
		String jsonAdresse = mapper.writeValueAsString(recette);

		mockMvc.perform(
				put("/api/recette/" + recette.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonAdresse))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Recette 123456"));
	}

	@Test
	public void recetteGetByNbConvives() throws Exception {
		int sizeStart = recetteDao.findRecettesByNbConvives(1000L).size();
		Recette recette = new Recette();
		recette.setnbConvives(1000L);
		recette = recetteDao.save(recette);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(
				get("/api/recette/nb-convives/1000").contentType(MediaType.APPLICATION_JSON).content(jsonRecette))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void recetteGetByNbConvivesGreaterThan() throws Exception {
		int sizeStart = recetteDao.findRecettesByNbConvivesGreaterThan(1000L).size();
		Recette recette = new Recette();
		recette.setnbConvives(1000L);
		recette = recetteDao.save(recette);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(get("/api/recette/nb-convives-greater-than/1000").contentType(MediaType.APPLICATION_JSON)
				.content(jsonRecette)).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void recetteGetByNbConvivesSmallerThan() throws Exception {
		int sizeStart = recetteDao.findRecettesByNbConvivesSmallerThan(1000L).size();
		Recette recette = new Recette();
		recette.setnbConvives(1000L);
		recette = recetteDao.save(recette);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(get("/api/recette/nb-convives-smaller-than/1000").contentType(MediaType.APPLICATION_JSON)
				.content(jsonRecette)).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(sizeStart + 1));
	}

	@Test
	public void recetteGetByProcess() throws Exception {
		m2i.formation.model.Process process = new m2i.formation.model.Process();
		process = processDao.save(process);
		Long id = process.getId();
		Recette recette = new Recette();
		recette.setProcess(process);
		recette = recetteDao.save(recette);
		int sizeStart = recetteDao.findRecettesByProcess(id).size();

		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(
				get("/api/recette/process/{id}", id).contentType(MediaType.APPLICATION_JSON).content(jsonRecette))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(sizeStart));
	}

	@Test
	public void recetteGetByIngredients() throws Exception {
		Produit ingredient = new Produit();
		ingredient = produitDao.save(ingredient);
		Long id = ingredient.getId();

		Recette recette = new Recette();
		recette.setIngerients(List.of(ingredient));
		recette = recetteDao.save(recette);

		int sizeStart = recetteDao.findRecettesByIngredient(id).size();

		ObjectMapper mapper = new ObjectMapper();
		String jsonRecette = mapper.writeValueAsString(recette);
		mockMvc.perform(
				get("/api/recette/ingredient/{id}", id).contentType(MediaType.APPLICATION_JSON).content(jsonRecette))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$.length()").value(sizeStart));
	}

}