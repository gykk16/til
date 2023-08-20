package dev.glory.books.object.ch05.part01.movie;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;

public class DiscountCondition {

    @Getter
    private DiscountConditionType type;
    private int                   sequence;
    private DayOfWeek                                               dayOfWeek;
    private LocalTime                                               startTime;
    private LocalTime                                               endTime;

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

    public boolean isSatisfiedBy(Screening screening) {
        if (this.type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {

        LocalDateTime whenScreened = screening.getWhenScreened();
        return this.dayOfWeek.equals(whenScreened.getDayOfWeek())
               && whenScreened.toLocalTime().isAfter(this.startTime)
               && whenScreened.toLocalTime().isBefore(this.endTime);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return this.sequence == screening.getSequence();
    }
}
