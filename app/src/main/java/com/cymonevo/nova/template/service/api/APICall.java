package com.cymonevo.nova.template.service.api;

public interface APICall {
    void onResponse(APIResponse response);
    void onFailure(APIResponse response);
}
