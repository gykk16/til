package dev.glory.books.object.ch05.part02.movie;

import java.time.LocalDateTime;

import lombok.Getter;

import dev.glory.books.object.ch05.money.Money;
import dev.glory.books.object.ch05.part02.movie.movie.Movie;

/**
 * 상영
 */
public class Screening {

    private Movie         movie;
    @Getter
    private int           sequence;
    @Getter
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
