package dev.glory.stream.parallelstream;

import java.util.Collection;

public class ParallelStreamApp {

    public long usingCollectionsParallel(Collection<Book> books, int year) {

        return books.parallelStream()
                .peek(book -> System.out.println(Thread.currentThread().getName() + " : " + book.name()))
                .filter(book -> book.year() == year)
                .count();
    }

    public long usingStreamParallel(Collection<Book> books, int year) {

        return books.stream()
                .parallel()
                .peek(book -> System.out.println(Thread.currentThread().getName() + " : " + book.name()))
                .filter(book -> book.year() == year)
                .count();
    }
}
