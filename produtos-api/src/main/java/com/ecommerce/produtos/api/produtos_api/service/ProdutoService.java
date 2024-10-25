package com.ecommerce.produtos.api.produtos_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.produtos.api.produtos_api.model.Produto;
import com.ecommerce.produtos.api.produtos_api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPeloCodigo(String codigo){
        Optional<Produto> produto = produtoRepository.findByCodigo(codigo);

        if(produto.isPresent()){
            return produto.get();
        }
        return null;
    }

    public Page<Produto> listarProdutosPorCategoria(Pageable paginacao, Long idCategoria){
        return produtoRepository.findByCategoria_Id(paginacao, idCategoria);
        
    }


    
}
