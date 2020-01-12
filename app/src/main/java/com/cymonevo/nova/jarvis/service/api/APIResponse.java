package com.cymonevo.nova.jarvis.service.api;

public class APIResponse {
    public int status;
    public String message;
    public Object payload;

    public APIResponse(int status, String message, Object payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }
}
