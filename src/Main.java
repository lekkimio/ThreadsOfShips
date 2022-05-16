import generators.PierLoader;
import generators.ShipGenerator;
import ships.Ship;
import ships.Type;
import tunnel.Tunnel;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String []args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of ships:");

        int amOfSips = scanner.nextInt();

        Tunnel tunnel = new Tunnel();

        ShipGenerator ships = new ShipGenerator(tunnel,amOfSips);

        PierLoader pier1 = new PierLoader(tunnel, Type.BANANA);
        PierLoader pier2 = new PierLoader(tunnel, Type.BREAD);
        PierLoader pier3 = new PierLoader(tunnel, Type.CLOTHES);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.execute(ships);

        executor.execute(pier1);
        executor.execute(pier2);
        executor.execute(pier3);

        executor.shutdown();
    }
}