package com.example.chronicle_storage.repository;

import com.example.chronicle_storage.model.ChronicleEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChronicleEventRepository extends JpaRepository<ChronicleEventEntity, String> { }