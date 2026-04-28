package com.raphael.sistema_pedidos.repositories;

import com.raphael.sistema_pedidos.entities.Order;
import com.raphael.sistema_pedidos.entities.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // 1. Busca por Status (Simples)
    List<Order> findByStatus(OrderStatus status);

    // 2. Busca por Status Paginada (Requisito do PDF)
    Page<Order> findByStatus(OrderStatus status, Pageable pageable);

    // 3. Busca por intervalo de Datas (Filtro avançado)
    List<Order> findByMomentBetween(Instant start, Instant end);

    // 4. Busca por ID do Cliente
    List<Order> findByClientId(Long clientId);
}