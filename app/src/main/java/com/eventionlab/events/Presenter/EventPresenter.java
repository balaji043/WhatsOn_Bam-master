package com.eventionlab.events.Presenter;

import android.content.Context;
import android.util.Log;

import com.eventionlab.events.Adapter.EventAdapter;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Model.WebService.ApiClient;
import com.eventionlab.events.Model.WebService.ApiInterface;
import com.eventionlab.events.View.EventView;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by malavan on 22/12/17.
 */

public class EventPresenter implements IEventPresenter
{


    private EventView eventView;
    private EventAdapter eventAdapter;
    private Context context;
    private Map<String,Event> eventMap;

    public EventPresenter(EventView eventView, Context context) {
        this.eventView = eventView;
        eventView.setPresenter(this);
        this.context = context;
    }

    @Override
    public void start() {
        reloadData();
    }


    @Override
    public void onAddItemClicked() {

    }

    @Override
    public void reloadData() {
        ApiInterface apiService =
                ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Map<String,Event>> call = apiService.getAllEvent();
        call.enqueue(new Callback<Map<String, Event>>() {
            @Override
            public void onResponse(Call<Map<String, Event>> call, Response<Map<String, Event>> response) {
               eventMap = response.body();
               eventView.setAdapter(new EventAdapter(eventMap,context));

            }

            @Override
            public void onFailure(Call<Map<String, Event>> call, Throwable t) {
                eventView.showNetworkError();

            }
        });

    }

    @Override
    public void onItemClicked(Event event) {

    }

    @Override
    public void onAboutClicked() {

    }
}
