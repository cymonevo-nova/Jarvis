package com.cymonevo.aurora.template;

import android.os.Bundle;
import android.widget.TextView;

import com.cymonevo.aurora.template.config.Config;
import com.cymonevo.aurora.template.core.retrofit.RetrofitClient;
import com.cymonevo.aurora.template.service.API.APICall;
import com.cymonevo.aurora.template.service.API.APIResponse;
import com.cymonevo.aurora.template.service.API.github.GithubAPI;
import com.cymonevo.aurora.template.service.API.github.request.ListRepoRequest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestScreen extends AppCompatActivity implements APICall {
    @BindView(R2.id.tv_test)
    TextView tvTest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test);
        ButterKnife.bind(this);
        RetrofitClient client = new RetrofitClient(Config.API_GITHUB_URL);
        GithubAPI.init(client.getInstance());
    }

    @OnClick(R2.id.btn_test) void action() {
        ListRepoRequest request = new ListRepoRequest("cymon1997");
        GithubAPI.listRepos(this, request);
    }

    @Override
    public void onResponse(APIResponse response) {
        this.tvTest.setText(String.format("status: %d\nmessage: %s\npayload: %s", response.status, response.message, response.payload));
    }

    @Override
    public void onFailure(APIResponse response) {
        this.tvTest.setText(String.format("status: %d\nmessage: %s\npayload: %s", response.status, response.message, response.payload));
    }
}
