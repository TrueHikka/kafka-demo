package ru.maxima.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final String TOPIC = "my_first_topic";
    private final String GROUP_ID= "my_first_group_id";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void listenTopic(String message) {
        System.out.println(message);
    }
}
