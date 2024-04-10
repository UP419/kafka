package com.example.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kafkaTopic", groupId = "groupId")
        //groupid is needed when we scale and have more than one instances of the same application
    void listener(String data) {
        System.out.println("Data was received - " + data);
    }
}
