package dev.glory.solid.l;

public class ElectricCar implements Car {

    @Override
    public void turnOnEngine() {
        throw new IllegalStateException("I don't have an engine!");
        /*
        엔진이 없는 자동차를 예외를 던지는 것은 프로그램의 동작을 명백하게 변경하는 것이다.
        이는 Liskov 치환 원칙을 위반하며, 이전 두 가지 원칙보다 수정하기 어렵다.

        (Liskov 치환 원칙은 슈퍼클래스의 객체를 서브클래스의 객체로 대체해도 프로그램의 정확성에 영향을 주지 않아야 한다)
         */
    }

    @Override
    public void accelerate() {

    }
}
