package dev.glory.solid.o;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperCoolGuitar extends Guitar {

    private String color;

    public SuperCoolGuitar(String make, String model, int volume, String color) {
        super(make, model, volume);
        this.color = color;
    }
}
