package com.example.chronicle_storage.controller;

import com.example.chronicle_storage.model.ChronicleEventEntity;
import com.example.chronicle_storage.repository.ChronicleEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final ChronicleEventRepository repo;

    public EventController(ChronicleEventRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ChronicleEventEntity> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ChronicleEventEntity getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }
}
