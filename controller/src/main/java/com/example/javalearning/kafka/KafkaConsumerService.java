package com.example.javalearning.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @PostConstruct
    public void init() {
        System.out.println("Kafka Consumer Started");
    }

    @KafkaListener(
            topics = "demo-topic",
            groupId = "demo-group-4"
    )
    public void consume(String message) {

        System.out.println("Message Received: " + message);
    }
}






