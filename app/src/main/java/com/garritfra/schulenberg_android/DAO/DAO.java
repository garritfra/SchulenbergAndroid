package com.garritfra.schulenberg_android.DAO;

import com.garritfra.schulenberg_android.model.Reservation;
import com.garritfra.schulenberg_android.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by garritfra on 27.02.18.
 */

public class DAO {

    public static boolean writeReservationToDatabase(User user, Reservation reservation) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        try {
            DatabaseReference reference = database.getReference((
                    ("users/" + user.getFirstName() + user.getLastName() + "/reservations")));
            String idString = Integer.toString(reservation.getId());
            reference.child(idString).setValue(reservation);

            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
