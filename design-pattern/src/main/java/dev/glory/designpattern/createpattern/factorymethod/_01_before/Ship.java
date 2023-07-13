package dev.glory.designpattern.createpattern.factorymethod._01_before;

import lombok.Getter;
import lombok.Setter;

public class Ship {

    private String name;
    private String color;

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
