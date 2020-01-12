package com.cymonevo.nova.jarvis.service.api;

public interface APICall {
    void onAPIResponse(int code, APIResponse response);
    void onAPIFailure(int code, String message);
}
