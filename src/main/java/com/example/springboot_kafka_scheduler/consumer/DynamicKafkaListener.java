package com.example.springboot_kafka_scheduler.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class DynamicKafkaListener {

    @KafkaListener(topicPattern = "topic-.*", groupId = "group_id")
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.printf("Received message from %s: %s%n", topic, message);
    }
}
