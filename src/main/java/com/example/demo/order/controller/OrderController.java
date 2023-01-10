package com.example.demo.order.controller;

import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping(value = "/selectList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEntity> selectLsit(@RequestBody OrderEntity orderEntity){
        return this.orderService.selectOrder(orderEntity);
    }

    @PostMapping(value = "/insertList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEntity> insertList(@RequestBody List<OrderEntity> list){
        return this.orderService.insertOrder(list);
    }

}
