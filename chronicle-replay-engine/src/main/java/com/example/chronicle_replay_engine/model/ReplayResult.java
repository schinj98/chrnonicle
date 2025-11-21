package com.example.chronicle_replay_engine.model;

public class ReplayResult {

    private int originalStatus;
    private Object replayedResponse;

    public ReplayResult() {
    }

    public ReplayResult(int originalStatus, Object replayedResponse) {
        this.originalStatus = originalStatus;
        this.replayedResponse = replayedResponse;
    }

    // GETTERS
    public int getOriginalStatus() {
        return originalStatus;
    }

    public Object getReplayedResponse() {
        return replayedResponse;
    }

    // SETTERS
    public void setOriginalStatus(int originalStatus) {
        this.originalStatus = originalStatus;
    }

    public void setReplayedResponse(Object replayedResponse) {
        this.replayedResponse = replayedResponse;
    }
}
