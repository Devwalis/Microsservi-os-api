package com.ecommerce_api.usuarios_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutenticacaoDTO {

    private String username;
    private String password;
    
}
