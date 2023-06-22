package dev.glory.oop.abstraction;

/*
Animal 은 본문이 없는 메소드인 makeSound()를 가진 추상 클래스
이 메소드는 Animal 의 서브클래스인 Dog 와 Cat 클래스에서 구현

makeSound() 메소드는 추상 메소드의 예시이며,
이 메소드는 Animal 을 직접 확장하는 비추상 클래스에서 반드시 구현
-> Dog 와 Cat 에서 구현

eat() 메소드는 구체적인 메소드로서,
추상 클래스에서 구현이 되어 있다.
서브클래스에서 이 메소드를 오버라이드하는 것은 필수가 아니며,
Animal 클래스에서 제공하는 그대로 사용할 수 있다.

---
다형성의 예시이기도 하다.
 */
public abstract class Animal {

    abstract void makeSound();

    public void eat() {
        System.out.println("The animal eats");
    }
}
