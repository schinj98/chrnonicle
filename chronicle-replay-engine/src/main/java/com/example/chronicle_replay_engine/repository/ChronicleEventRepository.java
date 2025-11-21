package com.example.chronicle_replay_engine.repository;


import com.example.chronicle_replay_engine.model.ChronicleEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChronicleEventRepository extends JpaRepository<ChronicleEventEntity, String> {
}
