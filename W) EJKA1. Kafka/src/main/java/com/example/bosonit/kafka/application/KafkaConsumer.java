package com.example.bosonit.kafka.application;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "NombreDelTopic", groupId = "myGroup") //ID declarado en el properties
    public void consumeMessage(String message) {
        LOGGER.info(String.format("Message received: %s", message));
    }
}
