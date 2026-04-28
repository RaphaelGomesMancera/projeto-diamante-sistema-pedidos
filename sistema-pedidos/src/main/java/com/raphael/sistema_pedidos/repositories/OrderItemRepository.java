package com.raphael.sistema_pedidos.repositories;

import com.raphael.sistema_pedidos.entities.OrderItem;
import com.raphael.sistema_pedidos.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}