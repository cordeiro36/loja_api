package com.loja.pedidos.domain.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderStatus {

    @NotNull
    private OrderStatus status;
}
