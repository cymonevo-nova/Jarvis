package com.cymonevo.nova.template.core;

import android.content.Context;
import android.content.Intent;

import com.cymonevo.nova.template.AuthScreen;
import com.cymonevo.nova.template.MainScreen;
import com.cymonevo.nova.template.TestScreen;

public class Router {
    public static void gotoTest(Context context) {
        context.startActivity(new Intent(context, TestScreen.class));
    }

    public static void gotoMain(Context context) {
        context.startActivity(new Intent(context, MainScreen.class));
    }

    public static void gotoLogin(Context context) {
        context.startActivity(new Intent(context, AuthScreen.class));
    }
}
