package com.example.bosonit.kafka.application;

import com.example.bosonit.kafka.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "NombreDelTopic").build();
        kafkaTemplate.send(message);

        LOGGER.info(String.format("Message sent: %s", user.toString()));
    }
}
