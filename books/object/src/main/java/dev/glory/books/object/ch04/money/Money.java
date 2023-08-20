package dev.glory.books.object.ch04.money;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {

    public static final Money ZERO = Money.wons(0);

    public static Money wons(long amt) {
        return new Money(BigDecimal.valueOf(amt));
    }

    public static Money wons(double amt) {
        return new Money(BigDecimal.valueOf(amt));
    }

    public Money plus(Money other) {
        return new Money(this.amount().add(other.amount()));
    }

    public Money minus(Money other) {
        return new Money(this.amount().subtract(other.amount()));
    }

    public Money times(double percent) {
        return new Money(this.amount().multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return this.amount().compareTo(other.amount()) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return this.amount().compareTo(other.amount()) >= 0;
    }
}
