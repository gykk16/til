package dev.glory.oop.encapsulation;

/*
캡슐화는 Car 클래스의 speed 필드에 어떻게 접근하고 수정할 수 있는지에 대한 통제력을 향상시키는 데 사용 된다.
private 으로 표시함으로써, 이 필드들이 클래스 외부에서 직접적으로 접근하거나 수정할 수 없게 한다.
대신, 이 필드들의 값을 가져오거나(modify) 수정하는(retrieve)데는 공개 "getter" 및 "setter" 메서드를 사용한다.
이것이 바로 캡슐화가 작동하는 방식이다.
 */
public class Car {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
