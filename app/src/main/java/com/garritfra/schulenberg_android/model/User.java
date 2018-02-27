package com.garritfra.schulenberg_android.model;

import android.os.Build;
import android.service.restrictions.RestrictionsReceiver;
import android.support.annotation.RequiresApi;

import com.garritfra.schulenberg_android.DAO.DAO;
import com.garritfra.schulenberg_android.DAO.ReservationDAO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;
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

        DAO.writeReservationToDatabase(this, reservation);


        //Boolean flag for future exception handling
        return true;
    }

    public boolean cancelReservation(Reservation reservation) {
        reservation.cancel();

        //Boolean flag for future exception handling
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LinkedList<Reservation> getUpcomingReservations() {

        LinkedList<Reservation> result = new LinkedList<>();

        for (Reservation reservation : this.reservationList) {
            if (reservation.getDateStart().isAfter(LocalDateTime.now())) {
                result.add(reservation);
            }
        }

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Reservation getNextReservation() {
        for (Reservation reservation : reservationList) {
            if (reservation.getDateStart().isAfter(LocalDateTime.now())) {
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
