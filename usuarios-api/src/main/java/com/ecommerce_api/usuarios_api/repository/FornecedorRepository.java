package com.ecommerce_api.usuarios_api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce_api.usuarios_api.models.Fornecedores;

@Repository
public interface FornecedorRepository  extends JpaRepository <Fornecedores, Long>{

    Optional<Fornecedores> findByCnpj(String cnpj);

    List<Fornecedores> findByRazaoSocialContainsIgnoreCase(String razaoSocial);

    List<Fornecedores> findByUsuario_NomeContainsIgnoreCase(String nome);

    Optional<Fornecedores> findByUsuario_Email(String email);

    
}
