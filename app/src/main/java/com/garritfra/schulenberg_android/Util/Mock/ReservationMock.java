package com.garritfra.schulenberg_android.Util.Mock;

import com.garritfra.schulenberg_android.model.Reservation;
import com.garritfra.schulenberg_android.model.User;

import java.util.Calendar;

/**
 * Created by garritfra on 24.02.18.
 */

public class ReservationMock {

    public static Reservation reservationMock() {
        Calendar dateStart = Calendar.getInstance();
        dateStart.add(Calendar.DATE, 5);

        Calendar dateEnd = dateStart;
        dateEnd.add(Calendar.DATE, 3);

        return new Reservation(UserMock.userMock(), dateStart, dateEnd, 3);
    }

}
