package com.jafar.week4.prorityqueue.Exercise;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public RandomizedPriorityQueue(int capacity) {
        this.pq = (Key[]) new Comparable[capacity];
    }

    public Key sample(){

        if(N < 1) throw new IllegalStateException("No elements");

        int randomIndex = 1 + StdRandom.uniformInt(N);
        return pq[randomIndex];
    }

    public Key delRandom(){

        if(N < 1) throw new IllegalStateException("No values left");
        int k = 1 + StdRandom.uniformInt(N);
        Key randomKey = pq[k];
        exch(k, N);
        pq[N--] = null;
        return randomKey;
        
    }

    public boolean isEmpty() {

        return N == 0;

    }

    public void insert(Key key) {

        pq[++N] = key;

        swim(N);

    }

    private void swim(int k) {

        while (k > 1 && less(k / 2, k)) {

            exch(k / 2, k);

            k = k / 2;

        }

    }

    private void sink(int k) {

        while (2 * k <= N) {

            int j = 2 * k;

            if (j < N && less(j, j + 1))
                j++;

            if (!less(k, j))
                break;

            exch(k, j);

            k = j;

        }

    }

    public Key delMax() {

        Key max = pq[1];

        exch(1, N--);

        sink(1);

        pq[N + 1] = null;

        return max;

    }

    private boolean less(int j, int i) {

        return pq[j].compareTo(pq[i]) < 0;

    }

    private void exch(int k, int j) {

        Key temp = pq[k];

        pq[k] = pq[j];

        pq[j] = temp;

    }

    

    public Key[] getPq() {
        return pq;
    }

    public int getN() {
        return N;
    }

    public static void main(String[] args) {
        RandomizedPriorityQueue<Integer> randomizedPriorityQueue = new RandomizedPriorityQueue<>(10);
        randomizedPriorityQueue.insert(5);    
        randomizedPriorityQueue.insert(4);
        randomizedPriorityQueue.insert(1);

        // System.out.println(randomizedPriorityQueue.sample());
        System.out.println(randomizedPriorityQueue.delRandom());        
        System.out.println(randomizedPriorityQueue.delRandom());
        System.out.println(randomizedPriorityQueue.delRandom());


    }

    public String printer(Key[] pq){
        return Arrays.toString(pq);
    }

}
