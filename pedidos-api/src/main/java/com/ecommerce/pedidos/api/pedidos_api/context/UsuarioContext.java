package com.ecommerce.pedidos.api.pedidos_api.context;

import org.springframework.stereotype.Component;

import com.ecommerce.web.client.web_client.usuario.UsuarioDTO;

import lombok.Data;


@Data
@Component
public class UsuarioContext {


    private UsuarioDTO usuarioDTO;
    
}
