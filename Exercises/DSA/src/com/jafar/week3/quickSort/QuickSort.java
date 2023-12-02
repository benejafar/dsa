package com.jafar.week3.quickSort;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] a) {
        // StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    public static Comparable select(Comparable[] a, int k){
        StdRandom.shuffle(a);
        int lo  = 0 , hi  = a.length -1 ;
        while ( hi > lo ){
            int j = partition(a, lo, hi);
            if( j < k) lo = j + 1;
            else if ( j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // if (hi <= lo + 10 -1 ){
        //     Insertion.sort(a,lo,hi);

        //     return;
        // }
        // if(hi<=lo) return ;
        // int m = medianOf3(a,lo,lo+(hi-lo)/2,hi);
        // swap(a,lo,m);
        if(hi <= lo ) return ;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;
            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;

            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, j, lo);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    //debug helper
    private static String listPrinter(Comparable[] a){
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        String s = "STOPONEQUALKEYS";
        String[] a = s.split("");
        quickSort.sort(a);
        System.out.println(Arrays.asList(a));
        

    }

}
