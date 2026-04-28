package com.raphael.sistema_pedidos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório") // Requisito de Validação
    private String name;

    @Positive(message = "O preço deve ser positivo")
    private Double price;
}