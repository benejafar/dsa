package com.jafar.week4.prorityqueue.Exercise;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TaxiCabNumbers {

    public PriorityQueue<Integer> findTaxiCabNumberWithinN(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        Set<Integer> seen = new HashSet<>();

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sumOfCubes = (int) (Math.pow(i, 3) + Math.pow(j, 3));
                if (seen.contains(sumOfCubes)) {
                    minHeap.offer(sumOfCubes);
                }
                seen.add(sumOfCubes);
            }
        }

        return minHeap;

    }

    public static void main(String[] args) {
        TaxiCabNumbers taxiCabNumbers = new TaxiCabNumbers();
        PriorityQueue<Integer> taxiCabNumber = taxiCabNumbers.findTaxiCabNumberWithinN(100);
        while(taxiCabNumber.size() != 0){
            System.out.println(taxiCabNumber.poll());
        }
    }

}
