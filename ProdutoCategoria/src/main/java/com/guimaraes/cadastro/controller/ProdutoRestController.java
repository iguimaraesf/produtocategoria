package com.guimaraes.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.cadastro.modelo.Produto;
import com.guimaraes.cadastro.service.ProdutoService;

@RestController
public class ProdutoRestController {
	public static final String URL = "/api/v1/admin/produtos";

	@Autowired
	private ProdutoService service;
	@GetMapping(URL)
	public Page<Produto> listagem(Pageable pagina) {
		return service.obterTodos(pagina);
	}

	@PostMapping(URL)
	public Produto gravar(@Valid @RequestBody Produto produto) {
		return service.gravar(produto);
	}
	
	@DeleteMapping(URL + "/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
