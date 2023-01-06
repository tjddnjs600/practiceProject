package com.example.demo.order.service.impl;

import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

}
