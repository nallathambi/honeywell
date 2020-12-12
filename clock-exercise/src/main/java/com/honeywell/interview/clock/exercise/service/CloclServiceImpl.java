package com.honeywell.interview.clock.exercise.service;

import com.honeywell.interview.clock.exercise.model.Time;
import org.springframework.stereotype.Service;

@Service
public class CloclServiceImpl implements CloclService{

    @Override
    public Time getAngle(int hour, int min) {

        final double MINUTES_PER_HOUR = 60;
        final double DEGREES_PER_MINUTE = 360 / MINUTES_PER_HOUR;
        final double DEGREES_PER_HOUR = 360 / 12;

        double minuteAngle = min * DEGREES_PER_MINUTE;
        double hourAngle = hour * DEGREES_PER_HOUR +
                (min / MINUTES_PER_HOUR) * DEGREES_PER_HOUR;

        double diff = Math.abs(minuteAngle - hourAngle);
        if (diff > 180)
            new Time(hour,min,360 - (int) diff);
        return new Time(hour,min,(int)diff);
    }
}
