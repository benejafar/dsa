import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class PercolationStats {

    int n;
    int T;
    Percolation percolation;
    double[] means;
    double sampleMean;
    double stdDev;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        this.n = n;
        this.T = trials;
        means = new double[trials];
    }

    // sample mean of percolation threshold
    public double mean(){
        double sumOfMean = 0;
        for(int i = 0 ; i < T ; i ++ ){
            percolation = new Percolation(n);
            while(!percolation.percolates()){
                Random random = new Random();
                int row = random.nextInt(50) + 1;
                int col = random.nextInt(50) + 1;
                percolation.open(row,col);
            }
            double trailMean = (percolation.numberOfOpenSites()*1.0)/(n*n);
            means[i] = trailMean;
            sumOfMean += trailMean;
        }
        sampleMean = sumOfMean/T;
        return sampleMean;
    }

    public double stddev(){
        double numerator = 0;
        for (double i : means){
            numerator += Math.pow((i-sampleMean),2);
        }
        double squareOfStDev = (numerator / (T-1));
        stdDev = Math.pow(squareOfStDev,0.5);
        return stdDev;
    }

    public double confidenceLo(){
        double lo = (sampleMean - ((1.96*stdDev)/Math.pow(T,0.5)));
        return lo;
    }

    public double confidenceHi(){
        return (sampleMean + ((1.96*stdDev)/Math.pow(T,0.5)));
    }

//    // test client (see below)
    public static void main(String[] args){
        int a,b;
        a = StdIn.readInt();
        b = StdIn.readInt();

        try {
            PercolationStats pp = new PercolationStats(a,b);
            StdOut.println("mean                    = " + pp.mean());
            StdOut.println("stddev                  = " + pp.stddev());
            StdOut.println("95% confidence interval = [" + pp.confidenceLo() + ", " + pp.confidenceHi() + "]");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }


}
