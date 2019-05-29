package com.cymonevo.nova.template.service;

import com.cymonevo.nova.template.config.api.GithubConfig;
import com.cymonevo.nova.template.core.retrofit.RetrofitClient;
import com.cymonevo.nova.template.service.api.github.GithubAPI;

public class Provider {
    private static GithubAPI githubAPI;

    public static GithubAPI getGithubAPI() {
        if (githubAPI == null) {
            githubAPI = new GithubAPI(new RetrofitClient(GithubConfig.BASE_URL));
        }
        return githubAPI;
    }
}
