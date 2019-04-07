package com.cymonevo.aurora.template;

import android.os.Bundle;

import com.cymonevo.aurora.template.config.Config;
import com.cymonevo.aurora.template.core.Router;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Config.DEBUG_MODE) {
            Router.gotoTest(this);
        }
    }
}
