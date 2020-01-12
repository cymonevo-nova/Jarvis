package com.cymonevo.nova.jarvis;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cymonevo.nova.jarvis.config.Config;
import com.cymonevo.nova.jarvis.core.Router;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);
        Thread loading = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    finishLoading();
                } finally {
                    finishLoading();
                }
            }
        };
        loading.start();
    }

    private void finishLoading() {
        if (Config.DEBUG_MODE) {
            Router.gotoTest(this);
        } else {
            Router.gotoMain(this);
        }
        finish();
    }
}
