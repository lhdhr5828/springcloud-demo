package com.lee.boot.kafka.demo;

import com.lee.boot.kafka.demo.entity.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

//@Component
public class KafkaConfig {


//    @Bean
    public KafkaListenerContainerFactory batchFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setBatchListener(true);

        return factory;

    }

}
