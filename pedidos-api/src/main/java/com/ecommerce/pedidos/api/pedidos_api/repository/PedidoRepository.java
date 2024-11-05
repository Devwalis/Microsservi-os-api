package com.ecommerce.pedidos.api.pedidos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pedidos.api.pedidos_api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
