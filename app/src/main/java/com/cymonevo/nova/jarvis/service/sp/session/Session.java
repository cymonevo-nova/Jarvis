package com.cymonevo.nova.jarvis.service.sp.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.cymonevo.nova.jarvis.config.sp.SessionConfig;
import com.cymonevo.nova.jarvis.service.sp.session.entity.LoginData;

public class Session {
    private SharedPreferences service;

    public Session(Context context) {
        service = context.getSharedPreferences(SessionConfig.BASE_KEY, Context.MODE_PRIVATE);
    }

    public LoginData getLoginData() {
        String uuid = service.getString(SessionConfig.KEY_USER_UUID, "");
        String name = service.getString(SessionConfig.KEY_USER_NAME, "");
        return "".equals(uuid)? null : new LoginData(uuid, name);
    }

    public void setLoginData(LoginData data) {
        SharedPreferences.Editor editor = service.edit();
        editor.putString(SessionConfig.KEY_USER_UUID, data.uuid);
        editor.putString(SessionConfig.KEY_USER_NAME, data.name);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = service.edit();
        editor.clear();
        editor.apply();
    }
}
