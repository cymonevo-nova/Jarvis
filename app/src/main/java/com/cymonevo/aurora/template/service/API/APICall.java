package com.cymonevo.aurora.template.service.API;

public interface APICall {
    void onResponse(APIResponse response);
    void onFailure(APIResponse response);
}
