package com.garritfra.schulenberg_android.DAO;

import com.garritfra.schulenberg_android.model.Reservation;
import com.garritfra.schulenberg_android.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by garritfra on 27.02.18.
 */

public class ReservationDAO extends DAO {

    static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static boolean writeReservationToDatabase(Reservation reservation) {
        User user = reservation.getUser();
        DatabaseReference reference = database.
                getReference("user/" + user.getFirstName() + user.getLastName());
        reference.setValue(user);
        reference.child("reservations").setValue(reservation);
        return true;
    }

    public static List<Reservation> readUserReservationListFromDatabase(User user) {

        final List<Reservation> reservationsList = user.getReservationList();

        DatabaseReference reference = database.getReference("users/" + user.getId() +
                "/reservations/");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (Reservation reservation : (List<Reservation>) dataSnapshot.getChildren().iterator()) {
                    reservationsList.add(reservation);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return reservationsList;

    }
}
