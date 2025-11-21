package com.example.chronicle_replay_engine.service;

import com.example.chronicle_replay_engine.model.ChronicleEventEntity;
import com.example.chronicle_replay_engine.model.ReplayResult;
import com.example.chronicle_replay_engine.repository.ChronicleEventRepository;
import com.google.gson.Gson;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReplayService {

    private final ChronicleEventRepository repo;
    private final WebClient client = WebClient.builder().build();
    private final Gson gson = new Gson();

    public ReplayService(ChronicleEventRepository repo) {
        this.repo = repo;
    }

    public ReplayResult replay(String eventId) {

        ChronicleEventEntity event = repo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        String url = event.getUrl();
        String method = event.getMethod();

        System.out.println("Replaying Event for URL: " + url);

        // 🔥 1. Make the replay request
        String body = client.method(HttpMethod.valueOf(method))
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("ERROR: Could not replay the request")
                .block();

        // 🔥 2. Try to parse response as JSON
        Object parsedJson;
        try {
            parsedJson = gson.fromJson(body, Object.class);
        } catch (Exception e) {
            parsedJson = body; // fallback
        }

        // 🔥 3. Build ReplayResult
        ReplayResult result = new ReplayResult();
        result.setOriginalStatus(event.getStatus());
        result.setReplayedResponse(parsedJson);

        return result;
    }
}
