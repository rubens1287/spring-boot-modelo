package br.com.etec.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveraListarUsuarios() throws Exception {
		URI uri = new URI("/usuario");

		mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers
						.content()
						.json("[\n" +
								"    {\n" +
								"        \"id\": 1,\n" +
								"        \"nome\": \"Aluno\",\n" +
								"        \"email\": \"aluno@email.com\",\n" +
								"        \"senha\": \"123456\"\n" +
								"    },\n" +
								"    {\n" +
								"        \"id\": 2,\n" +
								"        \"nome\": \"Professor\",\n" +
								"        \"email\": \"professor@email.com\",\n" +
								"        \"senha\": \"123456\"\n" +
								"    }\n" +
								"]"))
				.andReturn();
	}

}
