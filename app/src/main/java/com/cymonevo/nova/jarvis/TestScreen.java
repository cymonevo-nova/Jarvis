package com.cymonevo.nova.jarvis;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cymonevo.nova.jarvis.core.Router;
import com.cymonevo.nova.jarvis.service.Provider;
import com.cymonevo.nova.jarvis.service.api.APICall;
import com.cymonevo.nova.jarvis.service.api.APIResponse;
import com.cymonevo.nova.jarvis.service.db.DBCall;
import com.cymonevo.nova.jarvis.service.db.user.DBResult;
import com.cymonevo.nova.jarvis.service.db.user.entity.UserData;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestScreen extends AppCompatActivity implements APICall, DBCall {
    @BindView(R2.id.tv_test)
    TextView tvTest;
    @BindView(R2.id.exo_test)
    PlayerView exoTest;
    @BindView(R2.id.img_test_1)
    ImageView imgTest1;
    @BindView(R2.id.img_test_2)
    ImageView imgTest2;
    @BindView(R2.id.img_test_3)
    ImageView imgTest3;
    @BindView(R2.id.img_test_4)
    ImageView imgTest4;
    @BindView(R2.id.img_test_5)
    ImageView imgTest5;
    private final int DB_LIST_USER_CODE = 10;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test);
        ButterKnife.bind(this);

    }

    @OnClick(R2.id.btn_test) void action() {
//        ListRepoRequest request = new ListRepoRequest("cymon1997");
//        Provider.getGithubAPI().listRepos(this, request);
        Provider.getUserDB(this).listUsers(this, DB_LIST_USER_CODE);
    }

    private void onLoad(List<UserData> data) {
        String result = "result: \n";
        for (int i = 0; i < data.size(); i++) {
            result += String.format("uuid: %s name: %s\n", data.get(i).uuid, data.get(i).name);
        }
        String output = result;
        tvTest.setText(output);
        Router.gotoMain(this);
    }

    @Override
    public void onAPIResponse(int code, APIResponse response) {
        this.tvTest.setText(String.format("status: %d\nmessage: %s\npayload: %s", response.status, response.message, response.payload));
    }

    @Override
    public void onAPIFailure(int code, String message) {
        this.tvTest.setText(String.format("message: %s", message));
    }

    @Override
    public void onDBResponse(int code, DBResult result) {
        switch (code) {
            case DB_LIST_USER_CODE:
                onLoad((List<UserData>) result.data);
                break;
        }
    }

    @Override
    public void onDBFailure(int code, String message) {
        Log.d("DB", "Error call db with code: " + message);
    }
}
