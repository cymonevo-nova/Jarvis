package com.cymonevo.aurora.template.core.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit client;

    public RetrofitClient(String url) {
        this.client = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getInstance() {
        return this.client;
    }
}
