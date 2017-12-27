package com.eventionlab.events.View;

import com.eventionlab.events.Adapter.EventAdapter;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Presenter.EventPresenter;

/**
 * Created by malavan on 22/12/17.
 */

public interface EventView extends BaseView<EventPresenter>{


   void showNetworkError();
   void setAdapter(EventAdapter eventAdapter);
}
