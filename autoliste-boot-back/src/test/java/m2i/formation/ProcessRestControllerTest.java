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
import m2i.formation.model.Process;

@SpringBootTest
@AutoConfigureMockMvc

class ProcessRestControllerTest {

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
	public void processGetAll() throws Exception {
		mockMvc.perform(get("/api/process")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// ==========
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	// ==========

	@Test
	public void getProcessById() throws Exception {
		List<Process> process = processDao.findAll();
		Long id = process.get(0).getId();

		mockMvc.perform(MockMvcRequestBuilders.get("/api/process/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
	}

	@Test
	public void processGetByNom() throws Exception {
		Process process = new Process();
		process.setNom("Bidule");
		process = processDao.save(process);

		mockMvc.perform(get("/api/process/nom/Bidule").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id", is(notNullValue())))
				.andExpect(jsonPath("$[0].nom").value("Bidule"));
	}

	@Test
	public void processDelete() throws Exception {
		Process process = new Process();
		process.setNom("Bidule");
		process = processDao.save(process);

		mockMvc.perform(delete("/api/process/{id}", process.getId())).andExpect(status().isOk());
	}

	@Test
	public void processPost() throws Exception {
		Process process = new Process("Process 987", "Description 987");
		ObjectMapper mapper = new ObjectMapper();
		String jsonProcess = mapper.writeValueAsString(process);
		mockMvc.perform(post("/api/process").contentType(MediaType.APPLICATION_JSON).content(jsonProcess))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value("Process 987")).andDo(print())
				.andExpect(jsonPath("$.description").value("Description 987")).andDo(print())
				.andExpect(jsonPath("$.version").value(0));
	}

	@Test
	public void processPut() throws Exception {
		String nom = "Process " + Math.random();
		Process process = new Process();
		process.setNom(nom);
		process = processDao.save(process);

		ObjectMapper mapper = new ObjectMapper();
		String jsonProcess = mapper.writeValueAsString(process);

		mockMvc.perform(
				put("/api/process/" + process.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonProcess))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.nom").value(nom));
	}

}