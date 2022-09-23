package com.example.bosonit.kafka.application;

import com.example.bosonit.kafka.domain.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "StringTopic", groupId = "myGroup") //ID declarado en el properties
    public void consumeStringMessage(String message) {
        LOGGER.info(String.format("String message received: %s", message));
    }

    @KafkaListener(topics = "JsonTopic", groupId = "myGroup") //ID declarado en el properties
    public void consumeJsonMessage(User user) {
        LOGGER.info(String.format("Json message received: %s", user.toString()));
    }
}
