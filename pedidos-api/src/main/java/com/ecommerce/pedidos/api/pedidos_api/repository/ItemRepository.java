package com.ecommerce.pedidos.api.pedidos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.pedidos.api.pedidos_api.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}