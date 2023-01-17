package com.example.demo.common.kafka;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.vo.MemberVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumerService {

    private MemberRepository memberRepository;
                                                                        /*tlqkf 그지같은 설정*/
    @KafkaListener(topics = "springTest", groupId = "sendTest", containerFactory = "memberChangeListener")
    @Transactional(rollbackFor = Exception.class)
    public void memberConsume(MemberVo member) throws InvocationTargetException, IllegalAccessException {
        log.info("kafka 테스트  :  "+ member);
        if(ObjectUtils.isNotEmpty(member)){
            MemberEntity saveEntity = new MemberEntity();
            BeanUtils.copyProperties(saveEntity, member);

            this.memberRepository.save(saveEntity);
        }
    }

    /*@KafkaListener(topics = "springTest", groupId = "springKafkaTest")
    public void consume(String member){
        log.info("kafka 테스트  :  "+ member);
    }*/
}
