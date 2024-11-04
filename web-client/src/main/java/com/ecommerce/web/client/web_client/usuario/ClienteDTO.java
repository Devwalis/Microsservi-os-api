package com.ecommerce.web.client.web_client.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
    
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String idade;
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    private String numero;
    private String complemento;
    
    
}
