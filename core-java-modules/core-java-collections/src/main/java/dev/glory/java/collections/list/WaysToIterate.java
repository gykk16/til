package dev.glory.java.collections.list;

import java.util.List;

/**
 * Ways to iterate a list
 * 리스트를 반복하는 방법
 */
public class WaysToIterate {

    List<String> countries = List.of("Korea", "USA", "UK", "France", "Germany", "Spain");

    /**
     * basic for loop, 기본 for 문
     */
    public void iterateWithForLoop() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }

    /**
     * enhanced for loop, 향상된 for 문
     */
    public void iterateWithEnhancedForLoop() {
        for (String country : countries) {
            System.out.println(country);
        }
    }

    /**
     * iterator, 반복자
     */
    public void iterateWithIterator() {
        var iterator = countries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Iterable.forEach(), 람다식
     */
    public void iterateWithForEach() {
        countries.forEach(System.out::println);
    }

    /**
     * Stream.forEach(), 람다식
     */
    public void iterateWithStreamForEach() {
        countries.stream().forEach(System.out::println);
    }

}
