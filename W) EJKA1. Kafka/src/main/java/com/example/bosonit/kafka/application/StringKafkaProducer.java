package com.example.bosonit.kafka.application;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StringKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        kafkaTemplate.send("NombreDelTopic", message);
    }
}
