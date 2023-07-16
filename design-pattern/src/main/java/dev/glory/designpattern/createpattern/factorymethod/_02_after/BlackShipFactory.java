package dev.glory.designpattern.createpattern.factorymethod._02_after;


public class BlackShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        Ship ship = new Ship("black");
        ship.setColor("black");
        return ship;
    }
}
