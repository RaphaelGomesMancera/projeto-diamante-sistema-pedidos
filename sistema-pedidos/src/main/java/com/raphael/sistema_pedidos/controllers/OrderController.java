package com.raphael.sistema_pedidos.controllers;

import com.raphael.sistema_pedidos.entities.Order;
import com.raphael.sistema_pedidos.entities.OrderStatus;
import com.raphael.sistema_pedidos.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    // 1. BUSCA TODOS (Com Paginação - Requisito do PDF)
    // Teste: http://localhost:8080/orders?page=0&size=5
    @GetMapping
    public ResponseEntity<Page<Order>> findAll(Pageable pageable) {
        Page<Order> list = repository.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    // 2. BUSCA POR ID
    // Teste: http://localhost:8080/orders/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(obj -> ResponseEntity.ok().body(obj))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. FILTRO POR STATUS (Busca 03)
    // Teste: http://localhost:8080/orders/filter-status?status=PAGO
    @GetMapping(value = "/filter-status")
    public ResponseEntity<List<Order>> findByStatus(@RequestParam OrderStatus status) {
        List<Order> list = repository.findByStatus(status);
        return ResponseEntity.ok().body(list);
    }

    // 4. FILTRO POR CLIENTE (Busca 04)
    // Teste: http://localhost:8080/orders/filter-client?clientId=1
    @GetMapping(value = "/filter-client")
    public ResponseEntity<List<Order>> findByClient(@RequestParam Long clientId) {
        List<Order> list = repository.findByClientId(clientId);
        return ResponseEntity.ok().body(list);
    }

    // 5. BUSCA SIMPLES DE TODOS (Sem paginação, para conferência rápida)
    @GetMapping(value = "/all")
    public ResponseEntity<List<Order>> findAllSimple() {
        return ResponseEntity.ok().body(repository.findAll());
    }
}