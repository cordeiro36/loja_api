package com.loja.pedidos.domain.product;


import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value // Cria uma classe imutável com getters e um construtor
public class RequestProduct {
        @NotNull String name;
        @NotNull int price_in_cents;
}