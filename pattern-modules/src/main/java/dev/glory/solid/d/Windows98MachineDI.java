package dev.glory.solid.d;

public class Windows98MachineDI {

    private final Monitor monitor;
    private final Keyboard keyboard;

    /*
    생성자를 통해 의존성을 주입 받음으로써,
    Windows98Machine 클래스는 Monitor 와 Keyboard 클래스에 의존하게 된다.
    이는 의존성 주입을 통해 느슨한 결합을 이루게 된다.
     */
    public Windows98MachineDI(Monitor monitor, Keyboard keyboard) {
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

}
