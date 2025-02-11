package com.ecommerce.web.client.web_client.usuario;



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

