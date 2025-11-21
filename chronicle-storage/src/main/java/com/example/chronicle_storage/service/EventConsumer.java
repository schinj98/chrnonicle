package com.example.chronicle_storage.service;

import com.example.chronicle_storage.model.ChronicleEventEntity;
import com.example.chronicle_storage.repository.ChronicleEventRepository;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    private final ChronicleEventRepository repo;
    private final Gson gson = new Gson();

    public EventConsumer(ChronicleEventRepository repo) {
        this.repo = repo;
    }

    @KafkaListener(topics = "chronicle-events", groupId = "chronicle-storage-group")
    public void consume(String message) {

        ChronicleEventEntity event =
                gson.fromJson(message, ChronicleEventEntity.class);

        repo.save(event);

        System.out.println("Saved Event: " + event.getId());
    }
}
