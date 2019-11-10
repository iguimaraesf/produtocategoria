package com.guimaraes.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guimaraes.cadastro.modelo.Produto;
import com.guimaraes.cadastro.service.ProdutoService;

@Controller
public class ProdutoController {
	public static final String URL = "/admin/produtos";

	@Autowired
	private ProdutoService service;
	@GetMapping(URL)
	public ModelAndView listagem(Pageable pagina) {
		Page<Produto> pags = service.obterTodos(pagina);
		ModelAndView view = new ModelAndView("/produtos/listagem", "produtos", pags.getContent());
		view.addObject("paginacao", pags.getPageable());
		return view;
	}
}
