package com.ecommerce_api.usuarios_api.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce_api.usuarios_api.models.Cliente;
import com.ecommerce_api.usuarios_api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(cliente));

        
    }

    @Secured({"ROLE_ADMIN", "ROLE_COLAB"})
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarClientes());

    }
    //Demais endpoints aqui...





@Autowired
private ClienteService clienteService;
}