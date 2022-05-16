package generators;

import ships.Ship;
import ships.Size;
import ships.Type;
import tunnel.Tunnel;

import java.util.Random;

public class ShipGenerator implements Runnable{
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;

    }


    @Override
    public void run() {
        int count = 0;

        while (count < shipCount){
            Thread.currentThread().setName("Ship Generator");
            count++;
            tunnel.add(new Ship(getRandomSize(),getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type getRandomType() {
        Random randType =  new Random();
        return Type.values()[randType.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random randSize =  new Random();
        return Size.values()[randSize.nextInt(Size.values().length)];
    }
}
