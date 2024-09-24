package com.ecommerce_api.usuarios_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    
    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;
    private String bairro;

}
