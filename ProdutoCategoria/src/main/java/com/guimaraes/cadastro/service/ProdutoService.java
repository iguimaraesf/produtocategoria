package com.guimaraes.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guimaraes.cadastro.modelo.Produto;
import com.guimaraes.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Page<Produto> obterTodos(Pageable pagina) {
		return repository.findAll(pagina);
	}

	public Produto gravar(Produto produto) {
		return repository.save(produto);
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
