package com.dataart.messaging.app.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageComponent {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "messagingTopic", group = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;

    }
}