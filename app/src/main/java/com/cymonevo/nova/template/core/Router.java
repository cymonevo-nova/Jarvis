package com.cymonevo.aurora.template.core;

import android.content.Context;
import android.content.Intent;

import com.cymonevo.aurora.template.TestScreen;

public class Router {
    public static void gotoTest(Context context) {
        context.startActivity(new Intent(context, TestScreen.class));
    }
}
