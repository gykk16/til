package dev.glory.books.object.ch05.part02.movie.discountcondition;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import dev.glory.books.object.ch05.part02.movie.Screening;

public class PeriodCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        LocalDateTime whenScreened = screening.getWhenScreened();
        return this.dayOfWeek.equals(whenScreened.getDayOfWeek())
               && whenScreened.toLocalTime().isAfter(this.startTime)
               && whenScreened.toLocalTime().isBefore(this.endTime);
    }

}
