package com.cymonevo.nova.jarvis;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cymonevo.nova.jarvis.core.Router;
import com.cymonevo.nova.jarvis.service.api.APICall;
import com.cymonevo.nova.jarvis.service.api.APIResponse;
import com.cymonevo.nova.jarvis.service.db.DBCall;
import com.cymonevo.nova.jarvis.service.db.user.DBResult;
import com.cymonevo.nova.jarvis.service.db.user.entity.UserData;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

public class TestScreen extends AppCompatActivity implements APICall, DBCall, RecognitionListener {
    @BindView(R2.id.tv_test)
    TextView tvTest;
    private static final int DB_LIST_USER_CODE = 10;
    private static final int SPEECH_REQUEST_CODE = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_test) void action() {
//        ListRepoRequest request = new ListRepoRequest("cymon1997");
//        Provider.getGithubAPI().listRepos(this, request);
//        Provider.getUserDB(this).listUsers(this, DB_LIST_USER_CODE);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    private void sphinx() throws IOException {
        File asset = new Assets(this).syncAssets();
        SpeechRecognizer recognizer = SpeechRecognizerSetup.defaultSetup().setAcousticModel(new File(asset, "en-us-ptm"))
                .setDictionary(new File(asset, "cmudict-en-us.dict")).getRecognizer();
        recognizer.addListener(this);
        recognizer.addKeyphraseSearch("wakeup", "oh god");
    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onPartialResult(Hypothesis hypothesis) {

    }

    @Override
    public void onResult(Hypothesis hypothesis) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            tvTest.setText(result.toString());
        }
        super.onActivityResult(requestCode, resultCode, data);
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
