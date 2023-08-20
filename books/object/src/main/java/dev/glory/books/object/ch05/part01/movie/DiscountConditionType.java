package dev.glory.books.object.ch05.part01.movie;

public enum DiscountConditionType {
    SEQUENCE("순번 조건"),
    PERIOD("기간 조건"),
    ;

    private final String description;

    DiscountConditionType(String description) {
        this.description = description;
    }
}
