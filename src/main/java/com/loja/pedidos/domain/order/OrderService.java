package com.loja.pedidos.domain.order;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(RequestOrder requestOrder) {
        Order order = new Order(requestOrder);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido com ID " + id + " não encontrado."));
    }

    @Transactional
    public Order updateOrderStatus(String id, UpdateOrderStatus updateStatus) {
        Order order = getOrderById(id);
        order.setStatus(updateStatus.getStatus());
        return orderRepository.save(order);
    }

    @Transactional
    public void cancelOrder(String id) {
        Order order = getOrderById(id);
        order.setStatus(OrderStatus.CANCELADO);
        orderRepository.save(order);
    }
}
