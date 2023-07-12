package dev.glory.designpattern.factorymethod._02_after;

public interface ShipFactory {

    default Ship orderShip(String name) {
        validate(name);
        prepare(name);

        Ship ship = createShip();

        notify(ship);
        return ship;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 지어주세요");
        }
    }

    private void prepare(String name) {
        System.out.println("주문한 배는 " + name + " 입니다.");
    }

    private void notify(Ship ship) {
        System.out.println("배를 만들었습니다.");
        System.out.println("ship = " + ship);
    }

    Ship createShip();
}
