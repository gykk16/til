package dev.glory.books.object.ch05.part02.movie.movie;

import java.time.Duration;

import dev.glory.books.object.ch05.money.Money;
import dev.glory.books.object.ch05.part02.movie.discountcondition.DiscountCondition;

public class PercentDiscountMovie extends Movie {

    private double discountPercent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double discountPercent,
            DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(discountPercent);
    }

}
