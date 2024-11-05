package com.loja.pedidos.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="orders")
@Entity(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String productId;
    private Integer quantity;
    private LocalDateTime orderDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDENTE;

    public Order(RequestOrder requestOrder) {
        this.productId = requestOrder.getProductId();
        this.quantity = requestOrder.getQuantity();
    }
}
