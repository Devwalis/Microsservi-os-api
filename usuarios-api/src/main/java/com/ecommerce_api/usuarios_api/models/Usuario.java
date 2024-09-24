package com.ecommerce_api.usuarios_api.models;

import com.ecommerce_api.usuarios_api.dto.UsuarioDTO;

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
public class Usuario {

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
        
        return dto;

    }

    }

  




    

