package dev.glory.stream.parallelstream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParallelStreamTest {

    @Test
    void using_collections_parallel() throws Exception {
        // given
        ParallelStreamApp parallelStreamApp = new ParallelStreamApp();

        // when
        long count = parallelStreamApp.usingCollectionsParallel(generateListOfBooks(), 1954);

        // then
        assertThat(count).isEqualTo(2L);
    }

    @Test
    void using_stream_parallel() throws Exception {
        // given
        ParallelStreamApp parallelStreamApp = new ParallelStreamApp();

        // when
        long count = parallelStreamApp.usingStreamParallel(generateListOfBooks(), 1954);

        // then
        assertThat(count).isEqualTo(2L);
    }

    private List<Book> generateListOfBooks() {
        Book book1 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954);
        Book book2 = new Book("The Two Towers", "J.R.R. Tolkien", 1954);
        Book book3 = new Book("The Return of the King", "J.R.R. Tolkien", 1955);
        Book book4 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book5 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        Book book6 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
        Book book7 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999);
        Book book8 = new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000);
        Book book9 = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003);
        Book book10 = new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005);
        Book book11 = new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007);

        return List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11);
    }
}