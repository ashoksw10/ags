package com.org.ags.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "creditCard-topic", groupId = "my-group-id")
    public void creditCardNotificationListener(String message) {
        System.out.println("Received message to follow up for CreditCard" +
                ": " + message);
    }

    @KafkaListener(topics = "email-topic", groupId = "my-group-id")
    public void emailNotificationListener(String message) {
        System.out.println("Received message to Send Email Notifications: " + message);
    }

    @KafkaListener(topics = "sms-topic", groupId = "my-group-id")
    public void smsNotificationListener(String message) {
        System.out.println("Received message to Send SMS Notifications: " + message);
    }

}