package dev.glory.lecture.l04;


public class Money implements Comparable<Money> {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Money o) {
        return this.amount - o.amount;
    }
}
