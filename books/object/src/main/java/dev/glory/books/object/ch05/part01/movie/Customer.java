package dev.glory.books.object.ch05.part01.movie;

import lombok.Getter;

@Getter
public class Customer {

    private String name;

    private String id;

    public Customer(String name, String id) {
        this.id = id;
        this.name = name;
    }
}
