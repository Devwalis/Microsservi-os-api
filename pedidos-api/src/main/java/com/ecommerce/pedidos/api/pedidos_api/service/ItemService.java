package com.ecommerce.pedidos.api.pedidos_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import com.ecommerce.pedidos.api.pedidos_api.model.Item;
import com.ecommerce.pedidos.api.pedidos_api.repository.ItemRepository;
import com.ecommerce.web.client.web_client.pedido.ItemDTO;
import com.ecommerce.web.client.web_client.produto.ProdutoDTO;

@Service
public class ItemService {

    public ProdutoDTO obterDetalhesDoProduto(String codigo) {
        RestTemplate template = new RestTemplate();

        String url = String.format("%s/produtos/codigo?codigo=%s", produtoWsURL, codigo);

        ResponseEntity<ProdutoDTO> response = template.getForEntity(url, ProdutoDTO.class);

        return response.getBody();
    }

    public ItemDTO salvarItem(Item item, ProdutoDTO produto) {
        return itemRepository.save(item). converterParaDTO(produto);

    }

    @Value(value = "${produtos.ws.url}")
    private String produtoWsURL;

    @Autowired
    private ItemRepository itemRepository;

    
    
}
