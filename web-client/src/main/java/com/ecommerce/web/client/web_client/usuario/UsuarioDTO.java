package com.ecommerce.web.client.web_client.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String telefone;
    private String celular;
    private String cpf;
    private String dataNascimento;
    private String tipoUsuario;
    private String token;


    
}
