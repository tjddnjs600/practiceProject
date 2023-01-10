package com.example.demo.order.service;

import com.example.demo.order.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> insertOrder(List<OrderEntity> list);

    List<OrderEntity> selectOrder(OrderEntity orderEntity);
}
