package dev.glory.books.object.ch05.part02.movie.discountcondition;

import dev.glory.books.object.ch05.part02.movie.Screening;

public class SequenceCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
