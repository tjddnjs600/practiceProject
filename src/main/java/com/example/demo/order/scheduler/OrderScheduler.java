package com.example.demo.order.scheduler;

import com.example.demo.common.scheduler.SchedulerConfig;
import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.entity.OrderRsltEntity;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.repository.OrderRsltRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class OrderScheduler {

    private OrderRepository orderRepository;

    private OrderRsltRepository orderRsltRepository;

//    @Scheduled(cron = "0 10 * * * *")
    /*@Scheduled(fixedDelay = 600000)
    @Transactional(rollbackFor = Exception.class)
    public void ordstatScheduler(){
        List<OrderEntity> ordList = orderRepository.findAll()
                .stream().sorted(Comparator.comparing(OrderEntity::getOrd_no).reversed())
                .filter(ord -> "200".equals(ord.getOrd_stat()))
                .limit(100).map(ord -> {
                    ord.setOrd_stat("1000");
                    return ord;
                }).collect(Collectors.toList());

        this.orderRepository.saveAll(ordList);
        log.debug("스케줄러test save  200");
    }

    @Scheduled(fixedDelay = 600000)
    @Transactional(rollbackFor = Exception.class)
    public void ordRsltScheduler(){

        List<OrderRsltEntity> list = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<OrderEntity> ordList = orderRepository.findAll().stream()
                .sorted(Comparator.comparing(OrderEntity::getOrd_no))
                .map(ord -> {
                    String today = LocalDateTime.now().format(formatter);
                    OrderRsltEntity obj = OrderRsltEntity.builder()
                            .ord_user_id(ord.getOrd_user_id())
                            .ord_stat(ord.getOrd_stat())
                            .ord_prod_qaty(ord.getOrd_prod_qaty())
                            .prod_cd(ord.getProd_cd())
                            .prod_nm(ord.getProd_nm())
                            .store_nm(ord.getStore_nm())
                            .regist_dt(today)
                            .update_dt(today).build();

                    list.add(obj);
                    return ord;
                }).collect(Collectors.toList());

        this.orderRsltRepository.saveAll(list);
        log.debug("스케줄러 save result  200");
    }*/

    /*@Scheduled(fixedDelay = 3000)
    public void testScheduler(){
        log.info("runEveryTenSecondsTwo time : " + LocalTime.now());
        log.info("1번 thread 이름  : " + Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 3000)
    public void testScheduler2(){
        log.info("runEveryTenSecondsTwo time : " + LocalTime.now());
        log.info("2번 thread 이름 : " + Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 3000)
    public void testScheduler3(){
        log.info("runEveryTenSecondsTwo time : " + LocalTime.now());
        log.info("3번 thread 이름 : " + Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 3000)
    public void testScheduler4(){
        log.info("runEveryTenSecondsTwo time : " + LocalTime.now());
        log.info("4번 thread 이름 : " + Thread.currentThread().getName());
    }*/
}
