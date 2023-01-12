package com.example.demo.common.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/kafkaTest")
public class KafkaProducerController {

    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendMsg")
    public void sendKafkMsg(@RequestBody String msg){
        log.debug("메세지  :  "+msg);
        this.kafkaProducerService.produce(msg);
    }
}
