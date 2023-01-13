package com.example.demo.common.kafka;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.vo.MemberVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaProducerService {

    /*@Autowired
    private KafkaTemplate<String, String> template;*/

    @Autowired
    private final KafkaTemplate<String, MemberVo> kafkaTemplate;

    private MemberRepository memberRepository;


    public void memberProduce(String msg){
        log.info("카프카 JSON 메세지 보내기 테스트ㅡㅡㅡ");
        MemberVo memberVo = new MemberVo();
        Optional<MemberEntity> sendEntity = this.memberRepository.findById(msg);
        sendEntity.ifPresent(obj -> {
            try {
                BeanUtils.copyProperties(memberVo, obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        this.kafkaTemplate.send("springTest",memberVo);
    }

    /*public void produce(String msg){
        log.info("카프카 메세지 보내기 테스트ㅡㅡㅡ");
        Optional<MemberEntity> sendEntity = this.memberRepository.findById(msg);
        sendEntity.ifPresent(memberEntity -> this.template.send("springTest", memberEntity.toString()));

    }*/
}
