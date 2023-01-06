package com.example.demo.order.scheduler;

import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class OrderScheduler {

    private OrderRepository orderRepository;

    @Scheduled(fixedDelay = 10000)
    @Transactional(rollbackFor = Exception.class)
    public void ordstatScheduler(){
        List<OrderEntity> ordList = orderRepository.findAll()
                .stream().sorted(Comparator.comparing(OrderEntity::getOrd_no).reversed())
                .filter(ord -> "200".equals(ord.getOrd_stat()))
                .limit(50).map(ord -> {
                    ord.setOrd_stat("500");
                    return ord;
                }).collect(Collectors.toList());

        this.orderRepository.saveAll(ordList);
        log.debug("스케줄러test save  200");
    }
}
