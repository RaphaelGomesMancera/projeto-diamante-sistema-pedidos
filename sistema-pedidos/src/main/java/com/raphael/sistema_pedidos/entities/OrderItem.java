package com.raphael.sistema_pedidos.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price; // Preço no momento da venda

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // Método para o cálculo automático exigido no projeto
    public Double getSubTotal() {
        return price * quantity;
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public Product getProduct() {
        return id.getProduct();
    }
}