package com.cymonevo.nova.template.service.API.github;

import com.cymonevo.nova.template.service.API.github.entity.GithubRepository;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<GithubRepository>> listRepos(@Path("user") String user);
}
