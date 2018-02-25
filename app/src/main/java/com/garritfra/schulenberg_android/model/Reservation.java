package com.garritfra.schulenberg_android.model;

import com.google.firebase.database.Exclude;

import java.util.Calendar;

/**
 * Created by garritfra on 24.02.18.
 * Model for Reservation
 */

public class Reservation extends BaseModel {

    private User user;
    private Calendar dateStart;
    private Calendar dateEnd;
    private int numberOfPeople;
    private boolean cancelled;

    public Reservation(User user, Calendar dateStart, Calendar dateEnd, int numberOfPeople) {

        super();
        this.user = user;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.numberOfPeople = numberOfPeople;
        this.cancelled = false;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void setCancelled(boolean bool) {
        this.cancelled = bool;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }


    public Calendar getDateEnd() {

        return dateEnd;
    }


    public void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Calendar getDateStart() {

        return dateStart;
    }


    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
