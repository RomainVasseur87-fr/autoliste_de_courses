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

import m2i.formation.dao.ICategorieDao;
import m2i.formation.dao.IProcessDao;
import m2i.formation.dao.IProduitDao;
import m2i.formation.dao.IRecetteDao;
import m2i.formation.dao.IThemeDao;
import m2i.formation.model.Theme;

@SpringBootTest
@AutoConfigureMockMvc

class ThemeRestControllerTest {

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
	public void themeGetAll() throws Exception {
		mockMvc.perform(get("/api/theme")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// ==========
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	// ==========

	@Test
	public void getThemeById() throws Exception {
		List<Theme> themes = themeDao.findAll();
		Long id = themes.get(0).getId();

		mockMvc.perform(MockMvcRequestBuilders.get("/api/theme/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
	}

	@Test
	public void themeGetByNom() throws Exception {
		double nombre = Math.random();
		String nom = "Thème " + nombre;
		Theme theme = new Theme(nom);
		theme = themeDao.save(theme);

		mockMvc.perform(get("/api/theme/nom/{nom}", nom).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value(nom));
	}

	@Test
	public void themePost() throws Exception {
		Theme theme = new Theme("Thème 1");
		ObjectMapper mapper = new ObjectMapper();
		String jsonTheme = mapper.writeValueAsString(theme);
		mockMvc.perform(post("/api/theme").contentType(MediaType.APPLICATION_JSON).content(jsonTheme))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Thème 1")).andDo(print()).andExpect(jsonPath("$.version").value(0));
	}

	@Test
	public void themePut() throws Exception {
		String nom = "Theme " + Math.random();
		Theme theme = new Theme();
		theme.setNom(nom);
		theme = themeDao.save(theme);

		ObjectMapper mapper = new ObjectMapper();
		String jsonTheme = mapper.writeValueAsString(theme);

		mockMvc.perform(put("/api/theme/" + theme.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonTheme))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value(nom));
	}

	@Test
	public void themeFindThemeByNom() throws Exception {
		Theme theme1 = new Theme("Bidule");
		theme1 = themeDao.save(theme1);
		Theme theme2 = themeDao.findThemeByNom("Bidule").get();
		mockMvc.perform(get("/api/theme/nom/Bidule")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.nom").value(theme2.getNom()));
	}

	@Test
	public void themeDelete() throws Exception {
		Theme theme = new Theme();
		theme = themeDao.save(theme);
		mockMvc.perform(delete("/api/theme/{id}", theme.getId())).andExpect(status().isOk());
	}
}