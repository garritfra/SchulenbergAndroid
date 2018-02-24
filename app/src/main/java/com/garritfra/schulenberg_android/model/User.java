package com.garritfra.schulenberg_android.model;

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
}
