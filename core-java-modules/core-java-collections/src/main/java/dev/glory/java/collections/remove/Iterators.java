package dev.glory.java.collections.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Iterators {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>(Arrays.asList("Korea", "USA", "UK", "France", "Germany", "Spain"));

        System.out.println("==> original list = " + String.join(", ", list));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String country = iterator.next();
            if (country.length() > 5) {
                iterator.remove();
            }
        }

        System.out.println("==> removed list = " + String.join(", ", list));
    }

}
