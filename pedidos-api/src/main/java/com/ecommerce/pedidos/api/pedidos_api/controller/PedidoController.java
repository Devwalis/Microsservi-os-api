package com.ecommerce.pedidos.api.pedidos_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pedidos.api.pedidos_api.context.UsuarioContext;
import com.ecommerce.pedidos.api.pedidos_api.model.Pedido;
import com.ecommerce.pedidos.api.pedidos_api.service.ItemService;
import com.ecommerce.pedidos.api.pedidos_api.service.PedidoService;
import com.ecommerce.web.client.web_client.pedido.ItemDTO;
import com.ecommerce.web.client.web_client.pedido.PedidoDTO;
import com.ecommerce.web.client.web_client.produto.ProdutoDTO;
import com.ecommerce.web.client.web_client.usuario.ClienteDTO;
import com.ecommerce.web.client.web_client.usuario.UsuarioDTO;




@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @PostMapping
    public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody Pedido pedido) {
        UsuarioDTO usuarioDTO = usuarioContext.getUsuarioDTO();


        if (!usuarioDTO.getAdministrador()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        ClienteDTO cliente = pedidoService.obterDetalhesDoCliente(pedido.getEmailCliente(),
            usuarioContext.getUsuarioDTO().getToken());


        List<ItemDTO> itens = pedido.getItens().stream().map(i -> {
            ProdutoDTO produto = itemService.obterDetalhesDoProduto(i.getCodigoProduto());

            return itemService.salvarItem(i, produto);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvarPedido(pedido, cliente, itens));
        }
    

    @Autowired
    private PedidoService pedidoService;


    @Autowired
    private ItemService itemService;

    @Autowired
    private UsuarioContext usuarioContext;
}
    

