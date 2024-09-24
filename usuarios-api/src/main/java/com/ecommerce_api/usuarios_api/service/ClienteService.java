package com.ecommerce_api.usuarios_api.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_api.usuarios_api.models.Cliente;
import com.ecommerce_api.usuarios_api.models.Endereco;
import com.ecommerce_api.usuarios_api.models.Usuario;
import com.ecommerce_api.usuarios_api.repository.ClienteRepository;
import com.ecommerce_api.usuarios_api.repository.UsuarioRepository;
import com.ecommerce_api.usuarios_api.dto.EnderecoDTO;


@Service
public class ClienteService {
  
public Cliente salvarCliente(Cliente cliente){
  String senha = cliente.getUsuario().getSenha();

  //Criptografar a senha para persistir no bancco
  BCryptPasswordEncoder encoder = autenticacaoService.getPasswordEncoder();

  String senhaCriptografarda = encoder.encode(senha);

  cliente.getUsuario().setSenha(senhaCriptografada);

  //buscar detalhes do enderecço pelo CEP
  Endereco endereco = cliente.getEndereco();

  EnderecoDTO enderecoDTO = enderecoService.buuscarEnderecoPeloCEP(endereco.getCep());

  endereco.setBairro(enderecoDTO.getBairro());
  endereco.setCidade(enderecoDTO.getLocalidade());
  endereco.setLogradouro(enderecoDTO.getLogradouro());
  endereco.setUf(enderecoDTO.getUf());

  //persistência do objeto usuario antes de relacionar com cliente
  Usuario usuario = usuarioRepository.save(cliente.getUsuario());
  cliente.setUsuario(usuario);

  return clienteRepository.save(cliente);

  
}




}
 



@Autowired
private ClienteRepository clienteRepository;

@Autowired
private UsuarioRepository usuarioRepository;

@Autowired
private EnderecoService enderecoService;
}