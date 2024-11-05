package com.ecommerce.pedidos.api.pedidos_api.context;

import org.springframework.stereotype.Component;

import lombok.Data;
import main.java.com.ecommerce.web.client.web_client.usuario.UsuarioDTO;

@Data
@Component
public class UsuarioContext {


    private UsuarioDTO usuarioDTO;
    
}
