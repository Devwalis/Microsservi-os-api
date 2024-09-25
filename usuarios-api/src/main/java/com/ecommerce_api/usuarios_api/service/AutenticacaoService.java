package com.ecommerce_api.usuarios_api.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce_api.usuarios_api.models.Usuario;
import com.ecommerce_api.usuarios_api.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //O username é o email do usuário
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        if(usuario.isPresent()){
            return usuario.get();

        }
        return null;


    }

    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();

    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
}
