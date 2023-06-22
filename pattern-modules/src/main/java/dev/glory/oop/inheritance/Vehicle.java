package dev.glory.oop.inheritance;

/*
상속은 한 클래스가 다른 클래스의 속성과 메소드를 상속받을 수 있게 한다.
'extends' 키워드를 사용하여 클래스 간의 상속을 구현할 수 있다.
 */
public class Vehicle {

    private int    wheels;
    private String model;

    public void start() {
        // the process of starting the vehicle
    }

    public void stop() {
        // process to stop the vehicle
    }

    public void honk() {
        // produces a default honk
    }

}
