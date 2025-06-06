package com.example.springboot_kafka_scheduler.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class KafkaProducerServiceTest {

    @Autowired
    private KafkaProducerService producerService;

    @Test
    void testSendMessage() {
        assertDoesNotThrow(() ->
                producerService.sendMessage("topic-test", "Hello Kafka"));
    }
}
