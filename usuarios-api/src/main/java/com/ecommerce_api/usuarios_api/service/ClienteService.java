package com.ecommerce_api.usuarios_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_api.usuarios_api.models.Cliente;
import com.ecommerce_api.usuarios_api.repository.ClienteRepository;


@Service
public class ClienteService {

  public Cliente salvarCliente(Cliente cliente){
    return clienteRepository.save(cliente);

  }
        

    
@Autowired
private ClienteRepository clienteRepository;

}