package com.ecommerce.pedidos.api.pedidos_api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.ecommerce.pedidos.api.pedidos_api.model.Pedido;
import com.ecommerce.pedidos.api.pedidos_api.repository.PedidoRepository;
import com.ecommerce.web.client.web_client.pedido.ItemDTO;
import com.ecommerce.web.client.web_client.pedido.PedidoDTO;
import com.ecommerce.web.client.web_client.usuario.ClienteDTO;

@Service
public class PedidoService {


    public ClienteDTO obterDetalhesDoCliente( String emailCliente, String token) {
        RestTemplate template = new RestTemplate();

        String url = String .format("%s/clientes/email?email=%s", usuarioWsURL, emailCliente);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ClienteDTO>  response = template.exchange(url, HttpMethod.GET, entity, ClienteDTO.class);

        return response.getBody();
    }

    public PedidoDTO salvarPedido(Pedido pedido, ClienteDTO cliente, List<ItemDTO> itens){
        return pedidoRepository.save(pedido).converterParaDTO(cliente, itens); 

        }


    @Value(value = "${usuario.ws.url}")
    private String usuarioWsURL;


    @Autowired
    private PedidoRepository pedidoRepository;

    }
    

