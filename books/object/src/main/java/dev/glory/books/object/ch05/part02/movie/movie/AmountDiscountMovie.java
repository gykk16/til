package dev.glory.books.object.ch05.part02.movie.movie;

import java.time.Duration;

import dev.glory.books.object.ch05.money.Money;
import dev.glory.books.object.ch05.part02.movie.discountcondition.DiscountCondition;

public class AmountDiscountMovie extends Movie {

    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount,
            DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
