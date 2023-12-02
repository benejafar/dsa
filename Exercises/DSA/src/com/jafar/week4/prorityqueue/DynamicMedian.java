package com.jafar.week4.prorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class DynamicMedian {
    private PriorityQueue<Integer> maxHeap;  // Max heap for the lower half
    private PriorityQueue<Integer> minHeap;  // Min heap for the upper half

    public DynamicMedian() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void insert(int num) {
        if (maxHeap.isEmpty() || num <= -maxHeap.peek()) {
            maxHeap.offer(-num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(-maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(-minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (-maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return -maxHeap.peek();
        }
    }

    public Double removeMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }

        double median;
        if (maxHeap.size() == minHeap.size()) {
            median = (double) (-maxHeap.poll() + minHeap.poll()) / 2;
        } else {
            median = -maxHeap.poll();
        }

        return median;
    }

    public static void main(String[] args) {
        DynamicMedian dynamicMedian = new DynamicMedian();
        dynamicMedian.insert(3);
        dynamicMedian.insert(1);
        dynamicMedian.insert(5);        
        // dynamicMedian.insert(6);


        System.out.println(dynamicMedian.findMedian());  // Output: 3.0
        System.out.println(dynamicMedian.removeMedian());  // Output: 3.0
        System.out.println(dynamicMedian.findMedian());  // Output: 1.0
    }
}

