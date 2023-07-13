# Factory Method Pattern

- 구체적으로 어떤 인스턴스를 만들지는 서브 클래스에서 결정하게 하는 패턴이다.
- 다양한 구현체가 있고, 그 중에서 특정한 구현체를 만들 수 있는 다양한 팩토리를 제공할 수 있다.

###  Factory Method Pattern 을 사용하는 이유

- 객체를 생성하는 코드를 별도의 클래스/메소드로 분리함으로써 객체 생성의 변화에 대비할 수 있다.
- 확장에 용이한 구조를 가지고 있다. (OCP)
- 기존 로직을 수정하지 않고도, 새로운 객체를 추가할 수 있다.
- 상품과 생성하는 팩토리간의 결합도가 낮다.

### Factory Method Pattern 의 단점

- 클래스의 수가 증가한다.
- 상품을 생성하는 팩토리 클래스가 많아진다.
- 팩토리 클래스가 많아지면서, 팩토리 클래스를 찾기 어려워진다.

### Factory Method Pattern 구현 방법

```java
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
```

```java
public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        Ship ship = new Ship("white");
        ship.setColor("white");
        return ship;
    }
}
```

```java
public class Client {

    public static void main(String[] args) {

        // Ship whiteShip = WhiteShipFactory.orderShip("white");
        // Ship blackShip = WhiteShipFactory.orderShip("black");

        // Ship white = new WhiteShipFactory().orderShip("white");
        // Ship black = new BlackShipFactory().orderShip("black");

        Client client = new Client();
        client.print(new WhiteShipFactory(), "white");
        client.print(new BlackShipFactory(), "black");
    }

    private void print(ShipFactory shipFactory, String name) {
        Ship ship = shipFactory.orderShip(name);
    }
}
```


