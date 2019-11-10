package com.guimaraes.cadastro.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.guimaraes.cadastro.modelo.Categoria;
import com.guimaraes.cadastro.modelo.Produto;
import com.guimaraes.cadastro.service.ProdutoService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {
	private static final String TITULO = "<title>Listagem de Produtos</title>";
	@Autowired
	private MockMvc mvc;
	@MockBean
	private ProdutoService service;
	
	@Test
	public void listarTodosOsProdutos() throws Exception {
		Pageable pg = PageRequest.of(0, 10);
		BDDMockito.given(service.obterTodos(pg)).willReturn(this.primeiraPaginaDeProdutos());
		mvc.perform(MockMvcRequestBuilders.get(ProdutoController.URL).accept(MediaType.TEXT_HTML))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString(TITULO)))
			.andExpect(MockMvcResultMatchers.model().attribute("produtos", this.primeiraPaginaDeProdutos()));
		
		Mockito.verify(service, Mockito.times(1)).obterTodos(pg);
	}

	private Page<Produto> primeiraPaginaDeProdutos() {
		Categoria c1 = new Categoria(1L, "Eletrodomésticos");
		Categoria c2 = new Categoria(2L, "Açougue");
		Categoria c3 = new Categoria(3L, "Servicos");
		Produto[] teste = {
				new Produto(1L, "Fogão Consul 4 Bocas CFO4NAR com Acendimento Automático - Inox", new BigDecimal("779"), c1, null),
				new Produto(2L, "Tomate Hortmix 500G", new BigDecimal("3.99"), c2, LocalDate.of(2020, 4, 1)),
				new Produto(3L, "Micro pigmentação de sobranelha", new BigDecimal("25"), c3, null),
		};
		return new PageImpl<>(Arrays.asList(teste));
	}
}
