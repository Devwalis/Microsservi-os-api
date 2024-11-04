package com.ecommerce.web.client.web_client.pedido;

import java.time.LocalDate;
import java.util.List;

import com.ecommerce.web.client.web_client.usuario.ClienteDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private ClienteDTO cliente;
    private double total;
    private LocalDate data;
    private List<ItemDTO> itens;
    
    
}
