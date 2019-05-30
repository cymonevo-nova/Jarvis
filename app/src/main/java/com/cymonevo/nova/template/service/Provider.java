package com.cymonevo.nova.template.service;

import android.content.Context;

import com.cymonevo.nova.template.config.api.GithubConfig;
import com.cymonevo.nova.template.config.db.DBConfig;
import com.cymonevo.nova.template.core.retrofit.RetrofitClient;
import com.cymonevo.nova.template.core.room.RoomClient;
import com.cymonevo.nova.template.service.api.github.GithubAPI;
import com.cymonevo.nova.template.service.db.user.UserDB;

public class Provider {
    private static GithubAPI githubAPI;
    private static UserDB userDB;

    public static GithubAPI getGithubAPI() {
        if (githubAPI == null) {
            githubAPI = new GithubAPI(new RetrofitClient(GithubConfig.BASE_URL));
        }
        return githubAPI;
    }

    public static UserDB getUserDB(Context context) {
        if (userDB == null) {
            userDB = new UserDB(new RoomClient(context, DBConfig.SQLITE_DB_NAME));
        }
        return userDB;
    }
}
