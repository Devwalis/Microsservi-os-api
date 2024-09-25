package com.ecommerce_api.usuarios_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String telefone;
    private String celular;
    private Boolean administrador;
    private Boolean colaborador;
    private Boolean usuarioExterno;
    private String token;
    
    
    
}
