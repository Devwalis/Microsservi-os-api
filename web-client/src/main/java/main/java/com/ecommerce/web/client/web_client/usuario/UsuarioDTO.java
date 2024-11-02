package main.java.com.ecommerce.web.client.web_client.usuario;

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
    private Boolean administrador;
    private Boolean colaborador;
    private Boolean usuarioExterno;
    private String token;

    
}
