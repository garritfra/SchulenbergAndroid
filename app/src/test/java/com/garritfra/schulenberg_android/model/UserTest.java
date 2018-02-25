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
 * User Class tests
 */


public class UserTest {
    User userMock;
    Reservation pastReservationMock;
    Reservation futureReservationMock;
    Reservation anotherFutureReservation;


    @Before
    public void setup() {
        futureReservationMock = null;
        futureReservationMock = ReservationMock.futureReservationMock();

        anotherFutureReservation = null;
        anotherFutureReservation = ReservationMock.futureReservationMock();
        anotherFutureReservation.getDateStart().add(Calendar.DATE, 5);
        anotherFutureReservation.getDateEnd().add(Calendar.DATE, 5);

        pastReservationMock = null;
        pastReservationMock = ReservationMock.pastReservationMock();

        userMock = null;
        userMock = UserMock.userMock();
    }

    @Test
    public void newReservation_returnsTrue() {
        Assert.assertTrue(userMock.newReservation(futureReservationMock));
    }

    @Test
    public void cancelReservation_returnsTrue() {
        Assert.assertTrue(userMock.cancelReservation(futureReservationMock));
    }

    @Test
    public void cancelReservation_marksReservationAsCanceled() {
        userMock.newReservation(futureReservationMock);
        userMock.getNextReservation().cancel();
        Assert.assertTrue(futureReservationMock.isCancelled());
    }

    @Test
    public void getUpcomingReservations_onlyReturnsUpcomingReservations() {
        userMock.newReservation(pastReservationMock);
        userMock.newReservation(futureReservationMock);
        userMock.newReservation(anotherFutureReservation);

        LinkedList<Reservation> expected = new LinkedList<>();
        expected.add(futureReservationMock);
        expected.add(anotherFutureReservation);

        LinkedList<Reservation> actual = userMock.getUpcomingReservations();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getNextReservation_returnsNextReservation() {

        userMock.newReservation(pastReservationMock);
        userMock.newReservation(futureReservationMock);
        userMock.newReservation(anotherFutureReservation);

        Assert.assertEquals(userMock.getNextReservation(), futureReservationMock);
    }

    @Test
    public void getNextReservations_noReservations_found() {
        Assert.assertNull(userMock.getNextReservation());
    }
}
