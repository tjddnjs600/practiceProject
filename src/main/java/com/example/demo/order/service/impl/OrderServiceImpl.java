package com.example.demo.order.service.impl;

import com.example.demo.common.threadPool.ThreadPoolConfig;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private MemberRepository memberRepository;

    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<OrderEntity> insertOrder(List<OrderEntity> list) {

        list = list.stream().peek(ord -> ord.setOrd_stat("1000")).collect(Collectors.toList());

        List<OrderEntity> finalList = list;
        Runnable r = () -> {
            List<OrderEntity> classList = this.orderRepository.findAll().stream().filter(ord -> ord.getOrd_user_id().equals(finalList.get(0).getOrd_user_id())).collect(Collectors.toList());

            MemberEntity member = this.memberRepository.findById(finalList.get(0).getOrd_user_id()).orElse(null);
            if(classList.size() > 20 && "F".equals(member.getUser_class_cd())){
                member.setUser_class_cd("B");
                this.memberRepository.save(member);
            }
        };

        this.threadPoolConfig.executor().execute(r);

        return this.orderRepository.saveAll(list);
    }

    @Override
    public List<OrderEntity> selectOrder(OrderEntity orderEntity) {
        return this.orderRepository.findAll().stream()
                .filter(ord -> ord.getOrd_user_id().equals(orderEntity.getOrd_user_id()))
                .collect(Collectors.toList());
    }
}
