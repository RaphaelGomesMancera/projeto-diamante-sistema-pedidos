package com.raphael.sistema_pedidos.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {}

    public Order(Long id, Instant moment, OrderStatus status, Client client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Instant getMoment() { return moment; }
    public void setMoment(Instant moment) { this.moment = moment; }

    public OrderStatus getStatus() { return OrderStatus.valueOf(status); }
    public void setStatus(OrderStatus status) {
        if (status != null) { this.status = status.getCode(); }
    }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Set<OrderItem> getItems() { return items; }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}