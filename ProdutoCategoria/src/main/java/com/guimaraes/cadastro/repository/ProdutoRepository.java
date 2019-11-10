package com.guimaraes.cadastro.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.guimaraes.cadastro.modelo.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

}
