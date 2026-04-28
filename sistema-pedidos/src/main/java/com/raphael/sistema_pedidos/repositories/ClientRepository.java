package com.raphael.sistema_pedidos.repositories;

import com.raphael.sistema_pedidos.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}