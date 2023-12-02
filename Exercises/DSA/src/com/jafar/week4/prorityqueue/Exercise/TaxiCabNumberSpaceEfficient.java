package com.jafar.week4.prorityqueue.Exercise;

import java.util.PriorityQueue;

public class TaxiCabNumberSpaceEfficient {



    public static PriorityQueue<Integer> findTaxiCabNumberWithinN(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Populate the min heap with taxicab numbers
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sumOfCubes = (int) (Math.pow(i, 3) + Math.pow(j, 3));
                minHeap.offer(sumOfCubes);
            }
        }

        // Create a set to track seen numbers
        // (optional, if you want to filter duplicates)
        // Set<Integer> seen = new HashSet<>();

        // Retrieve unique taxicab numbers from the min heap
        PriorityQueue<Integer> uniqueTaxicabs = new PriorityQueue<>();
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            // (optional) Check if the number is unique before adding
            // if (!seen.contains(current)) {
            uniqueTaxicabs.offer(current);
            // seen.add(current);
            // }
        }

        return uniqueTaxicabs;
    }

    public static void main(String[] args) {
        int n = 15; // You can adjust the value of n
        PriorityQueue<Integer> result = findTaxiCabNumberWithinN(n);

        while (!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
    }
}
