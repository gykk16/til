package dev.glory.designpattern.createpattern.factorymethod._01_before;

public class Client {

    public static void main(String[] args) {

        Ship whiteShip = ShipFactory.orderShip("white");
        Ship blackShip = ShipFactory.orderShip("black");
    }
}
