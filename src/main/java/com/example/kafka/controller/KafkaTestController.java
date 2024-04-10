package com.example.kafka.controller;


import com.example.kafka.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka")
public class KafkaTestController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaTestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("kafkaTopic", messageRequest.message());
    }
}
