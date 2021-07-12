package com.kfthomas.orama.model;

import com.kfthomas.orama.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class NetworkAcess {

    private static Retrofit sInstance;

    public static synchronized Retrofit getInstance(){
        if(sInstance == null)
            sInstance = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL_API)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

        return sInstance;
    }
}
