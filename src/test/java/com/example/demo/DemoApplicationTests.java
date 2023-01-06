package com.example.demo;

import com.example.demo.common.entity.ProdMstEntity;
import com.example.demo.common.entity.StoreMstEntity;
import com.example.demo.common.repository.ProdMstRepository;
import com.example.demo.common.repository.StoreMstRepository;
import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProdMstRepository prodMstRepository;

    @Autowired
    private StoreMstRepository storeMstRepository;

    @Test
    void contextLoads() {
        Optional<OrderEntity> ord = this.orderRepository.findById(1);
        if(ord.isPresent()){
            ord.get().setOrd_stat("500");
            this.orderRepository.save(ord.get());
        }
    }

}
