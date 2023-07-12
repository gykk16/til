package dev.glory.designpattern.factorymethod._02_after;

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
