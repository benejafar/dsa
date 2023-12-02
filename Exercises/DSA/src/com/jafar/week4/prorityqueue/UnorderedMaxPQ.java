package com.jafar.week4.prorityqueue;

import java.util.Arrays;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key x){
        pq[N++] = x;
    }

    public Key delMax(){
        System.out.println("before delmax" + printer(pq));
        int max = 0;
        for(int i = 1; i < N ; i++){
            if(less(max,i)) max=i;
        }
        System.out.println("maximum " + max);
        exch(max,N-1);
        System.out.println("after exchange" + printer(pq));

        Key maxKey = pq[--N];
        pq[N] = null;
        return maxKey;
    }

    private void exch(int max, int i) {
        Key temp = pq[max];
        pq[max] = pq[i];
        pq[i] = temp;
    }

    private boolean less(int max, int i) {
        return (pq[max]).compareTo(pq[i]) < 0;
    }


    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<>(8);
        Integer[] nums = {13,9,35,21,5};
        for(int i : nums){pq.insert(i);}
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());

    }

    public String printer(Comparable[] a){
        return Arrays.toString(a);
    }

}
