package com.ecommerce_api.usuarios_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.web.client.web_client.usuario.UsuarioDTO;
import com.ecommerce_api.usuarios_api.models.Usuario;
import com.ecommerce_api.usuarios_api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

   public UsuarioDTO criarUsuario(UsuarioDTO dto){
    if (usuarioRepository.existsByEmail(dto.getEmail())) {
        throw new RuntimeException("Email já cadastrado")
    }

    Usuario usuario = new Usuario();
    usuario.setEmail(dto.getEmail());
    usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
    usuario.setTelefone(dto.getEmail());
    
    
   }




    
}
