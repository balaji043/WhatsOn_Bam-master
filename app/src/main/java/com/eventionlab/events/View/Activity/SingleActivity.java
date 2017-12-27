package com.eventionlab.events.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eventionlab.events.Adapter.EventAdapter;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Presenter.EventPresenter;
import com.eventionlab.events.R;
import com.eventionlab.events.View.EventView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static com.eventionlab.events.Model.GetDate.getDate;

public class SingleActivity extends AppCompatActivity implements EventView{
    private static final String TAG = "SingleActivity" ;

    @BindView(R.id.iv_main_image)
    ImageView imageViewMain;
    @BindView(R.id.iv_main_goBack)
    ImageView imageViewGoBack;
    @BindView(R.id.iv_main_left)
    ImageView imageViewPrevious;
    @BindView(R.id.iv_main_right)
    ImageView imageViewNext;

    @BindView(R.id.tv_main_title)
    TextView textViewTitle;
    @BindView(R.id.tv_main_name)
    TextView textViewName;
    @BindView(R.id.tv_main_place)
    TextView textViewPlace;
    @BindView(R.id.tv_main_start)
    TextView textViewStart;
    @BindView(R.id.tv_main_end)
    TextView textViewEnd;
    @BindView(R.id.tv_main_cost)
    TextView textViewCost;
    @BindView(R.id.tv_main_about)
    TextView textViewAbout;
    @BindView(R.id.tv_main_route)
    TextView textViewRoute;

    @BindView(R.id.bt_main_route)
    Button buttonTickets;
    @BindView(R.id.bt_main_share)
    Button buttonShare;
    @BindView(R.id.bt_main_calender)
    Button buttonCalender;
    @BindView(R.id.bt_main_route)
    Button buttonRoute;

    Map<String ,Event> eventMap;
    Context context;
    int position;
    String dateFormat = "dd/MM/yyyy";
    List<Event> eventList = new ArrayList<>();
    public void data(){
        for (Map.Entry<String, Event> entry : eventMap.entrySet())
        {
            eventList.add(entry.getValue());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        textViewTitle       =   findViewById(R.id.tv_main_title);
        textViewName        =   findViewById(R.id.tv_main_name);
        textViewPlace       =   findViewById(R.id.tv_main_place);
        textViewStart       =   findViewById(R.id.tv_main_start);
        textViewEnd         =   findViewById(R.id.tv_main_end);
        textViewCost        =   findViewById(R.id.tv_main_cost);
        textViewAbout       =   findViewById(R.id.tv_main_about);
        textViewRoute       =   findViewById(R.id.tv_main_route);
        buttonTickets       =   findViewById(R.id.bt_main_tickets);
        buttonShare         =   findViewById(R.id.bt_main_share);
        buttonCalender      =   findViewById(R.id.bt_main_calender);
        buttonRoute         =   findViewById(R.id.bt_main_route);
        imageViewMain       =   findViewById(R.id.iv_main_image);
        imageViewGoBack     =   findViewById(R.id.iv_main_goBack);
        imageViewPrevious   =   findViewById(R.id.iv_main_left);
        imageViewNext       =   findViewById(R.id.iv_main_right);

        position = getIntent().getIntExtra("pos",0);

        try {
            if(getIntent().getExtras().getParcelable("event") != null) {
            final Event event = getIntent().getExtras().getParcelable("event");
            loaddata(event);
            }
        }catch (Exception e){
            Log.d(TAG, "onCreate: "+e.toString());
        }

        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position!=eventList.size()-1){
                    Event event = eventList.get(position + 1);
                    position++;
                    loaddata(event);
                }
            }
        });
        imageViewPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0) {
                    Event event = eventList.get(position-1);
                    position--;
                    loaddata(event);
                }
            }
        });
    }
    private void loaddata(final Event event) {
        textViewTitle.setText(event.getEvent_name());
        textViewName.setText(event.getEvent_name());
        textViewPlace.setText(event.getAddress());
        long smilliseconds = Long.parseLong(event.getStartDate());
        textViewStart.setText(getDate(smilliseconds,dateFormat));
        long emilliseconds = Long.parseLong(event.getStartDate());
        textViewEnd.setText(getDate(emilliseconds,dateFormat));
        textViewCost.setText(event.getPrice());
        textViewAbout.setText(event.getAbout_event());
        textViewRoute.setText(event.getAddress());
        Glide.with(context).load(event.getImg_url()).into(imageViewMain);
        buttonTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getWebsite()));
                startActivity(intent);
            }
        });
        buttonTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        buttonCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttonRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public void showNetworkError() {

    }

    @Override
    public void setAdapter(EventAdapter eventAdapter) {

    }

    @Override
    public void setPresenter(EventPresenter presenter) {

    }
}
