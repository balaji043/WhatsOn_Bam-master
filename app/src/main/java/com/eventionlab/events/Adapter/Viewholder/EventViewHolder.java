package com.eventionlab.events.Adapter.Viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Model.GetDate;
import com.eventionlab.events.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.eventionlab.events.Model.GetDate.getDate;

/**
 * Created by malavan on 22/12/17.
 */

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @BindView(R.id.iv_event_image)
    ImageView imageviewEvent;

    @BindView(R.id.tv_event_start)
    TextView textViewDateStart;
    @BindView(R.id.tv_event_time)
    TextView textview_event_timing;
    @BindView(R.id.tv_event_name)
    TextView textviewEventName;

    String dateFormat = "mm:ss dd/MM/yyyy";
    Context context;
    public EventViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = context;
        imageviewEvent          = itemView.findViewById(R.id.iv_event_image);
        textViewDateStart       = itemView.findViewById(R.id.tv_event_start);
        textview_event_timing   = itemView.findViewById(R.id.tv_event_time);
        textviewEventName       = itemView.findViewById(R.id.tv_event_name);
    }

    public void loaddata(Event event, Context context)
    {
        Glide.with(context).load(event.getImg_url()).into(imageviewEvent);
        Long l = Long.parseLong(event.getStartDate());
        textViewDateStart.setText(getDate(l,dateFormat));
        textviewEventName.setText(event.getEvent_name());
        textview_event_timing.setText(event.getID());
    }


    @Override
    public void onClick(View v) {

    }
}
