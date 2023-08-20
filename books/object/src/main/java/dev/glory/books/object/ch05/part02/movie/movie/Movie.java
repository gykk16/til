package dev.glory.books.object.ch05.part02.movie.movie;

import java.time.Duration;
import java.util.List;

import dev.glory.books.object.ch05.money.Money;
import dev.glory.books.object.ch05.part02.movie.Screening;
import dev.glory.books.object.ch05.part02.movie.discountcondition.DiscountCondition;

/**
 * 영화
 */
public abstract class Movie {

    private String                  title;
    private Duration                runningTime;
    private Money                   fee;
    private List<DiscountCondition> discountConditions;
    private Money                   discountAmount;
    private double                  discountPercent;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = List.of(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    protected abstract Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
