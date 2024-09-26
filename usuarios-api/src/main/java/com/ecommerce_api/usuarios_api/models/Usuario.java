package com.ecommerce_api.usuarios_api.models;

import com.ecommerce_api.usuarios_api.dto.UsuarioDTO;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable =false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = true, length = 20)
    private String telefone;

    @Column(nullable = true)
    private String celular;

    @Column(nullable = false)
    private Boolean administrador;

    @Column(nullable = false)
    private Boolean colaborador;

    @Column(nullable = false)
    private Boolean usuarioExterno;


    public Usuario(){
        this.administrador = Boolean.FALSE;
        this.colaborador = Boolean.FALSE;
        this.usuarioExterno = Boolean.FALSE;

    }

    public UsuarioDTO converterParaDTO(){
        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(nome);
        dto.setEmail(email);
        dto.setTelefone(telefone);
        dto.setCelular(celular);
        dto.setAdministrador(administrador);
        dto.setColaborador(colaborador);
        dto.setUsuarioExterno(usuarioExterno);
        dto.setToken(null);
        
        return dto;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(administrador){
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(colaborador){
            return List.of(new SimpleGrantedAuthority("ROlE_COLAB"));

        }
        if(usuarioExterno){
            return List.of(new SimpleGrantedAuthority("Role_EXT_USER"));

        }
        return null;
    }


    @Override
    public String getPassword(){
        return senha;

    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;

    }

    @Override
    public boolean isAccountNonLocked(){
        return true;



}

    @Override
    public boolean isCredentialsNonExpired(){   
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}


  




    

