package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.kafka.KafkaProducer;

@RestController
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/kafka")
    public ResponseEntity<String> sendMessage(@RequestParam("key") String message) {

        producer.writeMsg(message);

        return ResponseEntity.ok().body(message);
    }


}
