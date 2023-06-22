package dev.glory.solid.i;

/*
큰 인터페이스는 작은 인터페이스로 분할 한다.
이렇게 하면 구현 클래스는 자신에게 관심이 있는 메서드에만 신경 쓸 수 있도록 보장할 수 있다.

public interface BearCleaner {
    void washTheBear();
}

public interface BearFeeder {
    void feedTheBear();
}

public interface BearPetter {
    void petTheBear();
}

인터페이스를 분리함으로서 관심사는 분리 한다.
 */
public interface BearKeeper {

    void washTheBear();

    void feedTheBear();

    void petTheBear();

}
