package com.ecommerce_api.usuarios_api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutenticacaoDTO {



    @NotNull(message = "O e-mail do usuário não pode ser nulo.")
    @NotBlank(message = "Informe o e-mail do usuário.")
    private String username;


    @NotNull(message =  "A senha do usuário não pode ser nulo.")
    @NotBlank( message = "Informe a senha do usuário.")
    private String password;
    
}
