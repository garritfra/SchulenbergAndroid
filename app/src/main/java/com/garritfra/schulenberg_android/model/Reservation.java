package com.garritfra.schulenberg_android.model;

import com.google.firebase.database.Exclude;

import java.time.LocalDateTime;
/**
 * Created by garritfra on 24.02.18.
 * Model for Reservation
 */

public class Reservation extends BaseModel {

    private User user;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int numberOfPeople;
    private boolean cancelled;

    public Reservation(User user, LocalDateTime dateStart, LocalDateTime dateEnd, int numberOfPeople) {

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


    public LocalDateTime getDateEnd() {

        return dateEnd;
    }


    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDateTime getDateStart() {

        return dateStart;
    }


    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
