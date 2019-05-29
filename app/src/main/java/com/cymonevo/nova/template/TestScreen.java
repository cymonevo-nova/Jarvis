package com.cymonevo.nova.template;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cymonevo.nova.template.service.Provider;
import com.cymonevo.nova.template.service.api.APICall;
import com.cymonevo.nova.template.service.api.APIResponse;
import com.cymonevo.nova.template.service.api.github.GithubAPI;
import com.cymonevo.nova.template.service.api.github.request.ListRepoRequest;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestScreen extends AppCompatActivity implements APICall {
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test);
        ButterKnife.bind(this);
//        RetrofitClient client = new RetrofitClient(Config.API_GITHUB_URL);
//        GithubAPI.init(client.getInstance());

        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);
        exoTest.setPlayer(player);
        DefaultDataSourceFactory datasource = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "sample"));
        ExtractorsFactory extractor = new DefaultExtractorsFactory();
        ExtractorMediaSource source = new ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"), datasource, extractor, null, null);
        player.prepare(source);
        player.getPlayWhenReady();

//        imgTest1.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest2.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest3.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest4.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));
//        imgTest5.setImageDrawable(getResources().getDrawable(R.drawable.placeholder));

//        imgTest2.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.placeholder));

//        imgTest1.setImageBitmap(CompressorClient.drawableToBitmap(this, R.drawable.placeholder));
//        imgTest2.setImageBitmap(CompressorClient.drawableToBitmap(this, R.drawable.placeholder));
//        imgTest3.setImageBitmap(CompressorClient.drawableToBitmap(this, R.drawable.placeholder));
//        imgTest4.setImageBitmap(CompressorClient.drawableToBitmap(this, R.drawable.placeholder));
//        imgTest5.setImageBitmap(CompressorClient.drawableToBitmap(this, R.drawable.placeholder));
    }

    @OnClick(R2.id.btn_test) void action() {
        ListRepoRequest request = new ListRepoRequest("cymon1997");
        Provider.getGithubAPI().listRepos(this, request);
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
