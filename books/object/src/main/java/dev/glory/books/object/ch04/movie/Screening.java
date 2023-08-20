package dev.glory.books.object.ch04.movie;

import java.time.LocalDateTime;

import dev.glory.books.object.ch04.money.Money;

/**
 * 상영
 */
public class Screening {

    private Movie         movie;
    private int           sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount) {
        return switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> movie.isDiscountable(whenScreened, sequence)
                    ? movie.calculateAmountDiscountedFee().times(audienceCount)
                    : movie.calculateNoneDiscountedFee().times(audienceCount);
            case PERCENT_DISCOUNT -> movie.isDiscountable(whenScreened, sequence)
                    ? movie.calculatePercentDiscountedFee().times(audienceCount)
                    : movie.calculateNoneDiscountedFee().times(audienceCount);
            case NONE_DISCOUNT -> movie.calculateNoneDiscountedFee().times(audienceCount);
        };
    }

}
