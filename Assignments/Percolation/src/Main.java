import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Percolation per = new Percolation(1000);
        while (!per.percolates()){
            Random random = new Random();
            int a = random.nextInt(0,1000)+1;
            int b = random.nextInt(0,1000)+1;
            per.open(a,b);

        }
        System.out.println(per.numberOfOpenSites());
        System.out.println(stopwatch.elapsedTime());
    }
}
