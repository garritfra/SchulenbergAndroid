package com.garritfra.schulenberg_android.DAO;

import android.util.Log;

import com.garritfra.schulenberg_android.model.Reservation;
import com.garritfra.schulenberg_android.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by garritfra on 27.02.18.
 */

public class DAO {

    private static LinkedList<Reservation> reservationList = new LinkedList<>();

    public static boolean writeReservationToDatabase(User user, Reservation reservation) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        try {
            DatabaseReference reference = database.getReference(
                    "users/"
                            + user.getFirstName()
                            + user.getLastName()
                            + "/reservations");
            String idString = Integer.toString(reservation.getId());
            reference.child(idString).setValue(reservation);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static LinkedList<Reservation> getReservationsForUser(User user) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(
                "users/"
                        + user.getFirstName()
                        + user.getLastName()
                        + "/reservations");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                GenericTypeIndicator<LinkedList<Reservation>> typeIndicator = new
                        GenericTypeIndicator<LinkedList<Reservation>>() {
                        };


                for (DataSnapshot reservation : dataSnapshot.getChildren()) {
                    Reservation returnedReservation = (Reservation) reservation.getValue(Object.class);
                    reservationList.add(returnedReservation);
                    //TODO
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return reservationList;
    }


}
