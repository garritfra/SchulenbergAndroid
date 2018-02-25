package com.garritfra.schulenberg_android.Util.Mock;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.garritfra.schulenberg_android.model.Reservation;
import com.garritfra.schulenberg_android.model.User;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by garritfra on 24.02.18.
 * <p>
 * Mock for Reservation Class
 */

public class ReservationMock {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Reservation futureReservationMock() {
        LocalDateTime dateStart = LocalDateTime.now();
        dateStart.plusDays(5);

        LocalDateTime dateEnd = dateStart;
        dateEnd.plusDays(3);

        return new Reservation(UserMock.userMock(), dateStart, dateEnd, 3);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Reservation pastReservationMock() {
        LocalDateTime dateStart = LocalDateTime.now();
        dateStart.minusDays(5);

        LocalDateTime dateEnd = dateStart;
        dateEnd.plusDays(3);

        return new Reservation(UserMock.userMock(), dateStart, dateEnd, 3);
    }

}
