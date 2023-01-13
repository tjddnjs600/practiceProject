package com.example.demo.common.kafka;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "springTest", groupId = "springKafkaTest")
    public void memberConsume(MemberVo member){
        log.info("kafka 테스트  :  "+ member);
    }

    /*@KafkaListener(topics = "springTest", groupId = "springKafkaTest")
    public void consume(String member){
        log.info("kafka 테스트  :  "+ member);
    }*/
}
