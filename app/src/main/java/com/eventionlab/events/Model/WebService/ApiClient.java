package com.eventionlab.events.Model.WebService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by malavan on 14/12/17.
 */


public class ApiClient {

    public static final String BASE_URL = "https://whatsonapp-eventionlab.firebaseio.com/";

    private  static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static Retrofit getRetrofit() {
        return retrofit;
    }
}