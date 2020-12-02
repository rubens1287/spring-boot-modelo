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
class TopicosControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveraCadastrarUmTopico() throws Exception {
		URI uri = new URI("/topicos");

		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"\t\"titulo\":\"Novo Curso Test Controller\",\n" +
						"\t\"mensagem\":\"Adicionado novo curso via teste de unidade\",\n" +
						"\t\"nomeCurso\":\"Java Spring boot test\",\n" +
						"\t\"emailUsuario\": \"teste@controller.com\"\n" +
						"}"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect(MockMvcResultMatchers.jsonPath("$..id").value(4))
				.andExpect(MockMvcResultMatchers.jsonPath("$..titulo").value("Novo Curso Test Controller"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..mensagem").value("Adicionado novo curso via teste de unidade"));
	}

	@Test
	void deveraRetornaUmTopico() throws Exception {
		URI uri = new URI("/topicos/2");

		mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$..id").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$..titulo").value("Dúvida 2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..mensagem").value("Projeto não compila"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..dataCriacao").value("2019-05-05T19:00:00"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..nomeAutor").value("Professor"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..status").value("NAO_RESPONDIDO"));
	}

	@Test
	void deveraRetornaTopicoNotFound() throws Exception {
		URI uri = new URI("/topicos/10");

		mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	void deveraAtualizarUmTopico() throws Exception {
		URI uri = new URI("/topicos/1");

		mockMvc.perform(MockMvcRequestBuilders
				.put(uri)
				.content("{\n" +
						"\t\"titulo\":\"Update Novo Curso Test Controller\",\n" +
						"\t\"mensagem\":\"Adicionado novo curso via teste de unidade\",\n" +
						"\t\"nomeCurso\":\"Java Spring boot test\",\n" +
						"\t\"emailUsuario\": \"teste@controller.com\"\n" +
						"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$..id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$..titulo").value("Update Novo Curso Test Controller"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..mensagem").value("Adicionado novo curso via teste de unidade"))
				.andExpect(MockMvcResultMatchers.jsonPath("$..dataCriacao").value("2019-05-05T18:00:00"));
	}

	@Test
	void deveraAtualizarUmTopicoNotFound() throws Exception {
		URI uri = new URI("/topicos/10");

		mockMvc.perform(MockMvcRequestBuilders
				.put(uri)
				.content("{\n" +
						"\t\"titulo\":\"Update Novo Curso Test Controller\",\n" +
						"\t\"mensagem\":\"Adicionado novo curso via teste de unidade\",\n" +
						"\t\"nomeCurso\":\"Java Spring boot test\",\n" +
						"\t\"emailUsuario\": \"teste@controller.com\"\n" +
						"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	void deveraDeletarUmTopico() throws Exception {
		URI uri = new URI("/topicos/1");

		mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	void deveraDeletarUmTopicoNotFound() throws Exception {
		URI uri = new URI("/topicos/10");

		mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(404));
	}



}
