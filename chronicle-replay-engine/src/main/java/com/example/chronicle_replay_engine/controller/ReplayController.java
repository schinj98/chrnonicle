package com.example.chronicle_replay_engine.controller;

import com.example.chronicle_replay_engine.model.ReplayResult;
import com.example.chronicle_replay_engine.service.ReplayService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replay")
public class ReplayController {

    private final ReplayService replayService;

    // 🔥 Manual constructor instead of @RequiredArgsConstructor
    public ReplayController(ReplayService replayService) {
        this.replayService = replayService;
    }

    @GetMapping("/{eventId}")
    public ReplayResult replay(@PathVariable String eventId) {
        return replayService.replay(eventId);
    }
}
