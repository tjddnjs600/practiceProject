package com.example.demo.common.kafka;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private MemberRepository memberRepository;

    public void produce(String msg){
        log.info("카프카 메세지 보내기 테스트ㅡㅡㅡ");
        Optional<MemberEntity> sendEntity = this.memberRepository.findById(msg);
        sendEntity.ifPresent(memberEntity -> this.template.send("springTest", memberEntity.toString()));

    }
}
