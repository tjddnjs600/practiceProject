package com.example.demo.common.kafka;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.vo.MemberVo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, MemberVo> memberConsumer(){
        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        jsonDeserializer.setRemoveTypeHeaders(false);

        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG,"springKafkaTest");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new DefaultKafkaConsumerFactory<>(
                configs,
                new StringDeserializer(),
                new JsonDeserializer<>(MemberVo.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MemberVo> memberChangeListener(){
        ConcurrentKafkaListenerContainerFactory<String, MemberVo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(memberConsumer());
        return factory;
    }
}
