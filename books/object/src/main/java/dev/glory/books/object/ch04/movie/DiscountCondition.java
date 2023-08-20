package dev.glory.books.object.ch04.movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.Getter;

public class DiscountCondition {

    @Getter
    private DiscountConditionType type;
    private int                   sequence;
    private DayOfWeek             dayOfWeek;
    private LocalTime             startTime;
    private LocalTime             endTime;

    public DiscountCondition(int sequence) {
        this.type = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = DiscountConditionType.PERIOD;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek)
               && time.isAfter(this.startTime)
               && time.isBefore(this.endTime);
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
