package com.example.bosonit.kafka.infraestructure.controller;

import com.example.bosonit.kafka.application.StringKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private StringKafkaProducer stringKafkaProducer;

    @PostMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        stringKafkaProducer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body("Message sent to the topic");
    }
}
