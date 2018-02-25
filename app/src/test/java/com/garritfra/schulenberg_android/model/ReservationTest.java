package com.garritfra.schulenberg_android.model;

import com.garritfra.schulenberg_android.Util.Mock.ReservationMock;
import com.garritfra.schulenberg_android.Util.Mock.UserMock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by garritfra on 24.02.18.
 * Reservation test class
 */

public class ReservationTest {

    Reservation pastReservationMock;
    Reservation futureReservationMock;
    Reservation anotherFutureReservation;
    User userMock;

    @Before
    public void setup() {
        futureReservationMock = null;
        futureReservationMock = ReservationMock.futureReservationMock();

        anotherFutureReservation = null;
        anotherFutureReservation = ReservationMock.futureReservationMock();
        anotherFutureReservation.getDateStart().plusDays(5);
        anotherFutureReservation.getDateEnd().plusDays(5);

        pastReservationMock = null;
        pastReservationMock = ReservationMock.pastReservationMock();

        userMock = null;
        userMock = UserMock.userMock();

    }

    @Test
    public void cancel_cancelsReservation() {
        futureReservationMock.cancel();
        Assert.assertTrue(futureReservationMock.isCancelled());
    }


}
