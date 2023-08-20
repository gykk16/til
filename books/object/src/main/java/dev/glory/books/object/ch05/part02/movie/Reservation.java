package dev.glory.books.object.ch05.part02.movie;

import dev.glory.books.object.ch05.money.Money;

public class Reservation {

    private Customer  customer;
    private Screening screening;
    private Money     fee;
    private int                                         audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

}
