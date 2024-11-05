package com.ecommerce_api.usuarios_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.web.client.web_client.usuario.AutenticacaoDTO;
import com.ecommerce.web.client.web_client.usuario.UsuarioDTO;
import com.ecommerce_api.usuarios_api.models.Usuario;
import com.ecommerce_api.usuarios_api.service.TokenService;



@RestController
@RequestMapping("/auth")
public class AutenticacaoController {


    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO dto){
        //Autentticação de usuário pelo próprio spring Security
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        //Geração de token pelo usuário retornado
        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenService.gerarToken(usuario);

        UsuarioDTO usuarioDTO = usuario.converterParaDTO();
        usuarioDTO.setToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
    }

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;
}
