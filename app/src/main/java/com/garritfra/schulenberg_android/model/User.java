package com.garritfra.schulenberg_android.model;

import android.service.restrictions.RestrictionsReceiver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by garritfra on 24.02.18.
 */

public class User extends BaseModel {

    String firstName;
    String lastName;
    LinkedList<Reservation> reservationList;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservationList = new LinkedList<>();
    }

    public boolean newReservation(Reservation reservation) {
        //TODO
        return false;
    }

    public boolean cancelReservation(Reservation reservation) {
        //TODO
        return false;
    }

    public LinkedList<Reservation> getUpcomingReservations() {
        //TODO
        return new LinkedList<>();
    }

    public Reservation getNextReservation() {
        //TODO
        return this.reservationList.get(0);
    }

    public LinkedList<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(LinkedList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
