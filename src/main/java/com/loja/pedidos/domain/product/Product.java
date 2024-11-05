package com.loja.pedidos.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price_in_cents;

    private boolean active = true;

    public Product(RequestProduct request) {
        this.name = request.getName();
        this.price_in_cents = request.getPrice_in_cents();
    }
}