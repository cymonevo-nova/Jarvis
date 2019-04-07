package com.cymonevo.aurora.template.service.API.github;

import com.cymonevo.aurora.template.config.API.HttpMessage;
import com.cymonevo.aurora.template.config.API.HttpStatus;
import com.cymonevo.aurora.template.service.API.APICall;
import com.cymonevo.aurora.template.service.API.APIResponse;
import com.cymonevo.aurora.template.service.API.github.entity.GithubRepository;
import com.cymonevo.aurora.template.service.API.github.request.ListRepoRequest;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GithubAPI {
    private static GithubService service;

    public static void init(Retrofit client) {
        service = client.create(GithubService.class);
    }

    public static void listRepos(final APICall activity, ListRepoRequest request) {
        final Call<List<GithubRepository>> repos = service.listRepos(request.username);
        repos.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                int status; String message;
                if (response.isSuccessful()) {
                    status = HttpStatus.STATUS_OK;
                    message = HttpMessage.MSG_OK;
                } else {
                    status = HttpStatus.ERROR_INTERNAL_SERVER;
                    message = HttpMessage.MSG_500;
                }
                activity.onResponse(new APIResponse(status, message, response.body()));
            }

            @Override
            public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
                activity.onFailure(new APIResponse(HttpStatus.ERROR_CONNECTION, HttpMessage.MSG_600, null));
            }
        });
    }
}
