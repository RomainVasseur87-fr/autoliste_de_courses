package m2i.formation;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

@SpringBootTest
@AutoConfigureMockMvc
public class AdresseRestTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private IAdresseDao adresseDao;

	
	@Test
	@WithUserDetails("TestMock")
	public void adresseGet() throws Exception {
		mockMvc.perform(get("/api/adresse")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	@Test
	@WithUserDetails("TestMock")
	public void adressePost() throws Exception {
		Adresse adresse = new Adresse(1,"rue de la Paix", "1er étage", "Paris","75008", "France");

		ObjectMapper mapper = new ObjectMapper();
		String jsonAdresse = mapper.writeValueAsString(adresse);

		mockMvc.perform(post("/api/adresse").contentType(MediaType.APPLICATION_JSON).content(jsonAdresse))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.version").value(0))
				.andExpect(jsonPath("$.numero").value(1))
				.andExpect(jsonPath("$.rue").value("rue de la Paix"))
				.andExpect(jsonPath("$.complement").value("1er étage"))
				.andExpect(jsonPath("$.ville").value("Paris"))
				.andExpect(jsonPath("$.codePostal").value("75008"))
				.andExpect(jsonPath("$.pays").value("France"));

	}
	@Test
	@WithUserDetails("TestMock")
	public void adresseFindByVille() throws Exception {
		int sizeStart = adresseDao.findByVille("Ajaccio").size();

		Adresse adresse = new Adresse(1,"rue de la Paix", "1er étage", "Ajaccio","2A520", "France");
		adresseDao.save(adresse);

		Adresse adresse2 = new Adresse(1,"rue de la Paiqsdsdqsdqx", "1er étage", "FortLoingtain", "2A520", "France");
		adresseDao.save(adresse2);

		Adresse adresse3 = new Adresse(10 ,"rue de la Paiqsdsdqsdqx", "1er étage", "Ajaccio", "2A521", "France");
		adresseDao.save(adresse3);

		mockMvc.perform(get("/api/adresse/ville/Ajaccio")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 2));
	}
	@Test
	@WithUserDetails("TestMock")
	public void adresseFindByCodePostal() throws Exception {
		int sizeStart = adresseDao.findByCodePostal("2A520").size();

		Adresse adresse = new Adresse(1,"rue de la Paix", "1er étage", "Ajaccio","2A520", "France");
		adresseDao.save(adresse);

		Adresse adresse2 = new Adresse(1,"rue de la Paiqsdsdqsdqx", "1er étage", "Ajaccio", "2A520", "France");
		adresseDao.save(adresse2);

		Adresse adresse3 = new Adresse(10 ,"rue de la Paiqsdsdqsdqx", "1er étage", "Ajaccio", "2A521", "France");
		adresseDao.save(adresse3);

		mockMvc.perform(get("/api/adresse/codepostal/2A520")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 2));
	}
	
}
