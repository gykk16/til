package dev.glory.designpattern.createpattern.factorymethod._02_after;


public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        Ship ship = new Ship("white");
        ship.setColor("white");
        return ship;
    }
}
