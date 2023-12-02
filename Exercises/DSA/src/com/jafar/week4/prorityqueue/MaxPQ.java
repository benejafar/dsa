package com.jafar.week4.prorityqueue;

public class MaxPQ<Key extends Comparable<Key>> {

 

    private Key[] pq;

    private int N;

 

    public MaxPQ(int capacity){

        pq = (Key []) new Comparable[capacity + 1];

    }

 

    public boolean isEmpty(){

        return N == 0;

    }

 

    public void insert(Key key){

        pq[++N] = key;

        swim(N);

    }

 

    private void swim(int k ){

        while(k > 1 && less(k/2,k)){

            exch(k/2, k);

            k = k/2;

        }

    }

 

    private void sink(int k){

        while(2*k <= N){

            int j = 2*k;

            if(j<N && less(j,j+1)) j++;

            if(!less(k,j)) break;

            exch(k,j);

            k = j;

        }

    }

 

    public Key delMax(){

        Key max = pq[1];

        exch(1,N--);

        sink(1);

        pq[N+1] = null;

        return max;

    }

 

    private void exch(int k, int j) {

        Key temp = pq[k];

        pq[k] = pq[j];

        pq[j] = temp;

    }

 

    private boolean less(int j, int i) {

        return pq[j].compareTo(pq[i]) < 0;

    }

   

}

 