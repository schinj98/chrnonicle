package com.example.chronicle_storage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChronicleEventEntity {

    @Id
    private String id;

    private String url;
    private String method;
    private int status;
    private long requestTime;
    private long responseTime;

    public ChronicleEventEntity() {
    }

    public ChronicleEventEntity(String id, String url, String method, int status, long requestTime, long responseTime) {
        this.id = id;
        this.url = url;
        this.method = method;
        this.status = status;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
    }

    // GETTERS
    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public int getStatus() {
        return status;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public long getResponseTime() {
        return responseTime;
    }

    // SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
