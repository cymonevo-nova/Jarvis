package com.cymonevo.nova.template.core;

import android.content.Context;

import com.cymonevo.nova.template.service.sp.session.Session;
import com.cymonevo.nova.template.service.sp.session.entity.LoginData;

public class Auth {
    public static void login(Context context, LoginData data) {
        Session session = new Session(context);
        session.setLoginData(data);
    }

    public static void logout(Context context) {
        Session session = new Session(context);
        session.clear();
    }

    public static LoginData getLoggedData(Context context) {
        Session session = new Session(context);
        return session.getLoginData();
    }

    public static boolean isAuth(Context context) {
        Session session = new Session(context);
        return session.getLoginData() != null;
    }
}
