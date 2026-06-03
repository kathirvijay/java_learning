package com.example.javalearning.Usercontroller;

import com.example.javalearning.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController{

    private final KafkaProducerService producer;

    public KafkaController(
            KafkaProducerService producer) {

        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(
            @RequestParam String message) {

        producer.sendMessage(message);

        return "Message Sent Successfully";
    }
}