package com.cymonevo.aurora.template;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cymonevo.aurora.template.config.Config;
import com.cymonevo.aurora.template.core.compressor.CompressorClient;
import com.cymonevo.aurora.template.core.retrofit.RetrofitClient;
import com.cymonevo.aurora.template.service.API.APICall;
import com.cymonevo.aurora.template.service.API.APIResponse;
import com.cymonevo.aurora.template.service.API.github.GithubAPI;
import com.cymonevo.aurora.template.service.API.github.request.ListRepoRequest;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestScreen extends AppCompatActivity implements APICall {
    @BindView(R2.id.tv_test)
    TextView tvTest;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test);
        ButterKnife.bind(this);
//        RetrofitClient client = new RetrofitClient(Config.API_GITHUB_URL);
//        GithubAPI.init(client.getInstance());

//        imgTest1.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest2.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest3.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest4.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest5.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));

//        imgTest2.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.placeholder));

        imgTest1.setImageBitmap(CompressorClient.compressDrawable(this, R.drawable.placeholder));
        imgTest2.setImageBitmap(CompressorClient.compressDrawable(this, R.drawable.placeholder));
        imgTest3.setImageBitmap(CompressorClient.compressDrawable(this, R.drawable.placeholder));
        imgTest4.setImageBitmap(CompressorClient.compressDrawable(this, R.drawable.placeholder));
        imgTest5.setImageBitmap(CompressorClient.compressDrawable(this, R.drawable.placeholder));
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
