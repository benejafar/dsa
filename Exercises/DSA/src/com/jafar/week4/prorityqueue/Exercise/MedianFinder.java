package com.jafar.week4.prorityqueue.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

class MediaHeap {

    private PriorityQueue<Integer> large; 
    private PriorityQueue<Integer> small; 

    public MediaHeap(){
        large = new PriorityQueue<>(); //min heap
        small = new PriorityQueue<>(Collections.reverseOrder()); //max heap
    }

    public void addNum(Integer num){
        small.offer(num);

        //to make the values of smaller queue less than the value of large queue
        if(small.size() > 0 && large.size() > 0 
            && (small.peek() > large.peek())){
            large.offer(small.poll());
        }

        //to make the size of queue almost same
        if(small.size() > large.size() + 1){
            int val = small.poll();
            large.offer(val);
        }
        //to make the size of queue almost same
        if(large.size() > small.size() + 1){
            int val = large.poll();
            small.offer(val);
        }

    }

    public Double findMedian(){
        
        if(small.size() > large.size()){
            return small.peek()*1.0;
        }

        if(large.size() > small.size()){
            return large.peek()*1.0;
        }
        return ((small.peek() + large.peek())*1.0)/2;

    }

    

    public static void main(String[] args) {
        MediaHeap mediaHeap = new MediaHeap();
        mediaHeap.addNum(1);
        mediaHeap.addNum(5);
        mediaHeap.addNum(3);        
        mediaHeap.addNum(2);


        double k = mediaHeap.findMedian();
        System.out.println(k);


    }


}
