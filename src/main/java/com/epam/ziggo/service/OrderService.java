package com.epam.ziggo.service;

import java.util.List;

import com.epam.ziggo.entity.Order;
import com.epam.ziggo.repository.OrderRepository;
import com.epam.ziggo.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.saveAndFlush(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
