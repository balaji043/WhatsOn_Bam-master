package com.eventionlab.events.Model.WebService;

import com.eventionlab.events.Model.Event;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("/Events.json")
    Call<Map<String, Event>> getAllEvent();

}
