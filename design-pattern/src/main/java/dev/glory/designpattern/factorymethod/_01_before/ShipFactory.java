package dev.glory.designpattern.factorymethod._01_before;

public class ShipFactory {

    public static Ship orderShip(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 지어주세요");
        }

        prepare(name);
        Ship ship = new Ship(name);

        if (name.equals("white")) {
            ship.setColor("white");
        } else if (name.equals("black")) {
            ship.setColor("black");
        }

        notify(ship);
        return ship;
    }

    private static void notify(Ship ship) {
        System.out.println("배를 만들었습니다.");
        System.out.println("ship = " + ship);
    }

    private static void prepare(String name) {
        System.out.println("주문한 배는 " + name + " 입니다.");
    }
}
