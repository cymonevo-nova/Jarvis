package com.cymonevo.aurora.template;

import android.os.Bundle;

import com.cymonevo.aurora.template.config.Config;
import com.cymonevo.aurora.template.core.Router;
import com.cymonevo.aurora.template.core.retrofit.RetrofitClient;
import com.cymonevo.aurora.template.layout.HeaderFragment;
import com.cymonevo.aurora.template.module.list_repo.ListRepoFragment;
import com.cymonevo.aurora.template.service.API.github.GithubAPI;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class MainScreen extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnvironment();
        setContentView(R.layout.screen_main);
        HeaderFragment header = new HeaderFragment();
        ListRepoFragment fragment = new ListRepoFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.header_container, header)
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    private void setEnvironment() {
        if (Config.DEBUG_MODE) {
            Router.gotoTest(this);
        }
        RetrofitClient client = new RetrofitClient(Config.API_GITHUB_URL);
        GithubAPI.init(client.getInstance());
    }
}
