package com.ecommerce.pedidos.api.pedidos_api.model;

import java.time.LocalDate;
import java.util.List;

import com.ecommerce.web.client.web_client.pedido.ItemDTO;
import com.ecommerce.web.client.web_client.pedido.PedidoDTO;
import com.ecommerce.web.client.web_client.usuario.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailCliente;


    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;



    @OneToMany
    @JoinTable(name = "tb_compras_itens", joinColumns = @JoinColumn(name = "compra_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private  List<Item> itens;


    public PedidoDTO converterParaDTO(ClienteDTO cliente, List<ItemDTO> itens){
        PedidoDTO dto = new PedidoDTO();


        dto.setId(id);
        dto.setCliente(cliente);
        dto.setData(data);
        dto.setTotal(total);
        dto.setItens(itens);

        return dto;
    }
    
    
    
    
    
}
