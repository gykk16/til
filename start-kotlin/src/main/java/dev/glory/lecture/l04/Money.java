package dev.glory.lecture.l04;

import org.jetbrains.annotations.NotNull;

public class Money implements Comparable<Money>{

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(@NotNull Money o) {
        return this.amount - o.amount;
    }
}
