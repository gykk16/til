package dev.glory.oop.inheritance;

/*
Car 는 Vehicle 의 하위 클래스이다.
Car 는 Vehicle 의 모든 속성과 메소드를 상속 받아 사용 할 수 있다.

Java 는 단일 상속과 다중 레벨 상속을 지원 한다.
이는 한 클래스가 여러 클래스를 직접 상속받을 수 없다는 것을 의미 한다.
 */
public class Car extends Vehicle {

    private int numberOfGears;

    public void openDoors() {
        // process to open the doors
    }

}
