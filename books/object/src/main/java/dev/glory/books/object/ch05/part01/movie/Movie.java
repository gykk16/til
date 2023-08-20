package dev.glory.books.object.ch05.part01.movie;

import java.time.Duration;
import java.util.List;

import lombok.Getter;

import dev.glory.books.object.ch05.money.Money;

/**
 * 영화
 */
public class Movie {

    private String                  title;
    private Duration                runningTime;
    private Money                   fee;
    private List<DiscountCondition> discountConditions;
    @Getter
    private MovieType               movieType;
    private Money                   discountAmount;
    private double                  discountPercent;

    public Movie(String title, Duration runningTime, Money fee) {
        this(MovieType.NONE_DISCOUNT, title, runningTime, fee, Money.ZERO, 0);
    }

    public Movie(String title, Duration runningTime, Money fee, double discountPercent,
            DiscountCondition... discountConditions) {
        this(MovieType.PERCENT_DISCOUNT, title, runningTime, fee, Money.ZERO, discountPercent, discountConditions);
    }

    public Movie(String title, Duration runningTime, Money fee, Money discountAmount,
            DiscountCondition... discountConditions) {
        this(MovieType.AMOUNT_DISCOUNT, title, runningTime, fee, discountAmount, 0, discountConditions);
    }

    private Movie(MovieType movieType, String title, Duration runningTime, Money fee, Money discountAmount,
            double discountPercent, DiscountCondition... discountConditions) {
        this.movieType = movieType;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
        this.discountConditions = List.of(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountAmount() {
        return switch (movieType) {
            case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee();
            case PERCENT_DISCOUNT -> calculatePercentDiscountedFee();
            case NONE_DISCOUNT -> calculateNoneDiscountedFee();
        };
    }

    private Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    private Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    private Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }
}
