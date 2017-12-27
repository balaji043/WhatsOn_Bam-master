package com.eventionlab.events.Presenter;

import com.eventionlab.events.Model.Event;

/**
 * Created by malavan on 22/12/17.
 */

public interface IEventPresenter extends BasePresenter{
    void onAddItemClicked();

    void reloadData();

    void onItemClicked(Event event);

    void onAboutClicked();
}
