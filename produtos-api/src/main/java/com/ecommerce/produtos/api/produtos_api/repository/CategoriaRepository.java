package com.ecommerce.produtos.api.produtos_api.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos.api.produtos_api.model.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
