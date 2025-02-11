package com.ecommerce_api.usuarios_api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce_api.usuarios_api.models.Cliente;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    List<Cliente> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    Optional<Cliente> findByUsuario_Email(String email);

    List<Cliente> findByUsuario_NomeContainsIgnoreCase(String nome);

    List<Cliente> findByDataNascimento(LocalDate dataNascimento);
    
}
