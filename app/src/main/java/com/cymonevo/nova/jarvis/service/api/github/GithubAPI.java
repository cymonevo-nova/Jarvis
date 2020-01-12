package com.cymonevo.nova.jarvis.service.api.github;

import com.cymonevo.nova.jarvis.config.Http;
import com.cymonevo.nova.jarvis.core.retrofit.RetrofitClient;
import com.cymonevo.nova.jarvis.service.api.APICall;
import com.cymonevo.nova.jarvis.service.api.APIResponse;
import com.cymonevo.nova.jarvis.service.api.github.entity.GithubRepository;
import com.cymonevo.nova.jarvis.service.api.github.request.ListRepoRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubAPI {
    private static GithubService service;

    public GithubAPI(RetrofitClient client) {
        service = client.getInstance().create(GithubService.class);
    }

    public void listRepos(final APICall activity, int code, ListRepoRequest request) {
        final Call<List<GithubRepository>> repos = service.listRepos(request.username);
        repos.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> result) {
                APIResponse response;
                if (result.isSuccessful()) {
                    response = new APIResponse(Http.STATUS_OK, Http.MSG_OK, result.body());
                } else {
                    response = new APIResponse(Http.STATUS_ERROR_INTERNAL_SERVER, Http.MSG_ERROR_INTERNAL_SERVER, null);
                }
                activity.onAPIResponse(code, response);
            }

            @Override
            public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
                activity.onAPIFailure(code, t.getMessage());
            }
        });
    }
}
