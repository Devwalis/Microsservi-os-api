package com.ecommerce_api.usuarios_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.web.client.web_client.usuario.UsuarioDTO;
import com.ecommerce_api.usuarios_api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> listarUsuario(Pageable pageable){
        return ResponseEntity.ok(usuarioService.listarTodos(pageable));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEnitty<UsuarioDTO> buscarPorID(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
@Secured("ROLE_ADMIN")
@PutMapping("/{id)")
public ResponseEntity<UsuarioDTO> atualizarUsuario(
    @PathVariable Long id,
    @RequestBody UsuarioDTO dto
){
    return ResponseEntity.ok(usuarioService.atualizar(id, dto));
}
@PatchMapping("/{id}/senha")
public ResponseEnitty<Void> alterarSernha(
    @PatchVariable Long id,
    @RequestParam String novaSenha
){
    usuarioService.alterarSenha(id, novaSenha);
    returnResponseEnitty.ok().build();
}


}
