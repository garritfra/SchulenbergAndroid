package com.garritfra.schulenberg_android.model;

import com.garritfra.schulenberg_android.Util.Mock.ReservationMock;
import com.garritfra.schulenberg_android.Util.Mock.UserMock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by garritfra on 24.02.18.
 */

public class UserTest {
    User userMock;
    Reservation reservationMock;


    @Before
    public void setup() {
        UserMock.userMock();
        reservationMock = ReservationMock.reservationMock();
    }

    @Test
    public void newReservation_returnsTrue() {
        Assert.assertTrue(userMock.newReservation(reservationMock));
    }
}
