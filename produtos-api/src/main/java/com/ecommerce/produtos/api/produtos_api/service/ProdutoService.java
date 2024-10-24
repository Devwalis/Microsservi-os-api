package com.ecommerce.produtos.api.produtos_api.service;

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



    
}
