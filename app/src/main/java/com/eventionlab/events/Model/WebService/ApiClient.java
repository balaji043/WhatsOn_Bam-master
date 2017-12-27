package com.eventionlab.events.Model.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static final String BASE_URL = "https://whatsonapp-eventionlab.firebaseio.com/";

    private  static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static Retrofit getRetrofit() {
        return retrofit;
    }
}