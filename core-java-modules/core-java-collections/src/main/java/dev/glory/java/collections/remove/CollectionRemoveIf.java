package dev.glory.java.collections.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionRemoveIf {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>(Arrays.asList("Korea", "USA", "UK", "France", "Germany", "Spain"));

        System.out.println("==> original list = " + String.join(", ", list));

        list.removeIf(country -> country.length() > 5);

        System.out.println("==> removed list = " + String.join(", ", list));
    }

}
