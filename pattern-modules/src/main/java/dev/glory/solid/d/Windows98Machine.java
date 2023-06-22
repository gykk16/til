package dev.glory.solid.d;

public class Windows98Machine {

    private final StdKeybord keyboard;
    private final Monitor monitor;

    /*
    new 키워드를 사용하여 StdKeyboard 와 Monitor 를 선언함으로써,
    이 세 개의 클래스를 밀접하게 연결하게 된다.

    테스트의 어려움 뿐만 아니라 StdKeyboard 클래스를 다른 클래스로 바꾸는 것이 불가능 하고
    Monitor 클래스를 또한 갇혀 있다.
     */
    public Windows98Machine() {
        monitor = new Monitor();
        keyboard = new StdKeybord();
    }
}
