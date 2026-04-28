package com.raphael.sistema_pedidos.config;

import com.raphael.sistema_pedidos.entities.Client;
import com.raphael.sistema_pedidos.entities.Order;
import com.raphael.sistema_pedidos.entities.OrderStatus;
import com.raphael.sistema_pedidos.repositories.ClientRepository;
import com.raphael.sistema_pedidos.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        // Criando Cliente com os 4 campos que definimos no passo 1
        Client c1 = new Client(null, "Raphael Teste", "raphael@gmail.com", "99999999");
        clientRepository.save(c1);

        // Criando Pedido (Certifique-se que OrderStatus.PAGO existe no seu Enum)
        Order o1 = new Order(null, Instant.now(), OrderStatus.PAGO, c1);
        orderRepository.save(o1);

        System.out.println("DADOS DE TESTE INSTANCIADOS COM SUCESSO!");
    }
}