package com.ecommerce.produtos.api.produtos_api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos.api.produtos_api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

   
    Optional<Produto> findByCodigo(String codigo);

    Page<Produto> findByCategoria_Id(Pageable paginacao, Long id);
    

    

    
}
