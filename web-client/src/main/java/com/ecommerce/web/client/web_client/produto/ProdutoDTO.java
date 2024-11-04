package com.ecommerce.web.client.web_client.produto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String codigo;
    private String descricao;
    private Double preco;
    private String categoria;



    
}
