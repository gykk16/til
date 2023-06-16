package dev.glory.java.collections.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StreamFilter {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>(Arrays.asList("Korea", "USA", "UK", "France", "Germany", "Spain"));

        System.out.println("==> original list = " + String.join(", ", list));

        List<String> filteredList = list.stream().filter(country -> country.length() <= 5).toList();

        System.out.println("==> filtered list = " + String.join(", ", filteredList));
    }

}
