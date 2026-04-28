package com.raphael.sistema_pedidos.repositories;

import com.raphael.sistema_pedidos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}