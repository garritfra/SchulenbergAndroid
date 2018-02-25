package com.garritfra.schulenberg_android.model;

import android.service.restrictions.RestrictionsReceiver;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by garritfra on 24.02.18.
 * <p>
 * Base Model for ID Management
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
        this.reservationList.add(reservation);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("reservations");
        String idString = Integer.toString(reservation.getId());

        reference.child(idString).setValue(reservation);


        //Boolean flag for future exception handling
        return true;
    }

    public boolean cancelReservation(Reservation reservation) {
        reservation.cancel();

        //Boolean flag for future exception handling
        return true;
    }

    public LinkedList<Reservation> getUpcomingReservations() {

        LinkedList<Reservation> result = new LinkedList<>();

        for (Reservation reservation : this.reservationList) {
            if (reservation.getDateStart().after(Calendar.getInstance())) {
                result.add(reservation);
            }
        }

        return result;
    }

    public Reservation getNextReservation() {
        for (Reservation reservation : reservationList) {
            if (reservation.getDateStart().after(Calendar.getInstance())) {
                return reservation;
            }
        }
        return null;
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
