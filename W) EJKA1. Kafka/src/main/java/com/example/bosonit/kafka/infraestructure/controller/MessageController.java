package com.example.bosonit.kafka.infraestructure.controller;

import com.example.bosonit.kafka.application.JsonKafkaProducer;
import com.example.bosonit.kafka.application.StringKafkaProducer;
import com.example.bosonit.kafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private StringKafkaProducer stringKafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("publish/string")
    public ResponseEntity<String> publishString(@RequestParam("message") String message) {
        stringKafkaProducer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body("String message sent to the topic");
    }

    @PostMapping("publish/json")
    public ResponseEntity<String> publishJson(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.status(HttpStatus.OK).body("Json message sent to the topic");
    }
}
