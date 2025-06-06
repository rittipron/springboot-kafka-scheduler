package com.example.springboot_kafka_scheduler.scheduler;

import com.example.springboot_kafka_scheduler.service.KafkaProducerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DailyScheduler {
    private final KafkaProducerService producerService;

    public DailyScheduler(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @Scheduled(cron = "0 0 8 * * ?") // ทุกวัน 8 โมงเช้า
    public void fetchAndSend() {
        String topic = "topic-daily";
        String message = "Data fetched at " + LocalDateTime.now();
        producerService.sendMessage(topic, message);
        System.out.println("Scheduled data sent to Kafka");
    }
}
