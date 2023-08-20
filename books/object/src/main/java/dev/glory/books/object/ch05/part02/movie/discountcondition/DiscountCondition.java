package dev.glory.books.object.ch05.part02.movie.discountcondition;

import dev.glory.books.object.ch05.part02.movie.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
