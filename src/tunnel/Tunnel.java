package tunnel;

import ships.Ship;
import ships.Type;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private List<Ship> shipSpace;
    private static final int MAX_AMOUNT_OF_SHIPS = 5;
    private static final int MIN_AMOUNT_OF_SHIPS = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        shipSpace = new ArrayList<>();
    }

    public synchronized boolean add(Ship entity) {
        try {
            if (shipsCounter < MAX_AMOUNT_OF_SHIPS) {
                notifyAll();
                shipSpace.add(entity);
                System.out.println("The ship arrived in the tunnel: " + shipSpace.size() +" "
                        + entity.getType() +" "+ entity.getSize() );
                shipsCounter++;
            }
            else {
                System.out.println(shipSpace.size() + " Tunnel out of space: "
                        + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

        public synchronized Ship get(Type shipType) {
        try {
            if(shipsCounter>MIN_AMOUNT_OF_SHIPS){
                notifyAll();
                for(Ship ship: shipSpace){
                    if (ship.getType() == shipType){
                        shipsCounter--;
                        System.out.println(shipSpace.size() + " The ship left the tunnel: " + Thread.currentThread().getName());
                        shipSpace.remove(ship);
                        return ship;
                    }
                }
            }
            System.out.println("Tunnel is empty");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
