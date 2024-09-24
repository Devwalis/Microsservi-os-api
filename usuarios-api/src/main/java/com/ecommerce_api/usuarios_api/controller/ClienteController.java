package com.ecommerce_api.usuarios_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce_api.usuarios_api.models.Cliente;
import com.ecommerce_api.usuarios_api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(cliente));
    }

    



@Autowired
private ClienteService clienteService;
}