package dev.glory.solid.l;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MotorCar implements Car {

    /*
    부모 객체를 호출하는 동작에서 자식 객체가 부모 객체를 완전히 대체할 수 있어야 한다
     */

    private final Engine engine;

    @Override
    public void turnOnEngine() {
        engine.on();
    }

    @Override
    public void accelerate() {
        engine.powerOn(1_000);
    }
}
