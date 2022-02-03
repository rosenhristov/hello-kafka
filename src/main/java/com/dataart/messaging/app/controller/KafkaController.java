package com.dataart.messaging.app.controller;

import com.dataart.messaging.app.component.MessageComponent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private MessageComponent messageComponent;

    public KafkaController(KafkaTemplate<String, String> template, MessageComponent messageComponent) {
        this.template = template;
        this.messageComponent = messageComponent;
    }

    @GetMapping("/kafka/send")
    public void produce(@RequestParam String message) {
        template.send("messagingTopic", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return messageComponent.getMessages();
    }
}
