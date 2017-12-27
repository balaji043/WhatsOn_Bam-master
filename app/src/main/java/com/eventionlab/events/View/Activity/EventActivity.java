package com.eventionlab.events.View.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eventionlab.events.Adapter.EventAdapter;
import com.eventionlab.events.Presenter.EventPresenter;
import com.eventionlab.events.R;
import com.eventionlab.events.View.EventView;

public class EventActivity extends AppCompatActivity implements EventView {

    RecyclerView recyclerviewEvent;

    private EventPresenter eventPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
       recyclerviewEvent = findViewById(R.id.recyclerview_event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventPresenter = new EventPresenter(this,getApplicationContext());
        recyclerviewEvent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void setAdapter(EventAdapter eventAdapter) {
        recyclerviewEvent.setAdapter(eventAdapter);
    }

    @Override
    public void setPresenter(EventPresenter presenter) {
       eventPresenter =  presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventPresenter.start();
    }
}
