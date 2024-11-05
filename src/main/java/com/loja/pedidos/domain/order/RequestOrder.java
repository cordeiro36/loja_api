package com.loja.pedidos.domain.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestOrder {

    @NotNull
    private String productId;

    @NotNull
    private Integer quantity;
}