package com.jafar.week3.quickSort;

import java.util.Arrays;

public class ThreeWayQuickSort {

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return ;
        Comparable pivot = a[lo];
        int lt = lo, gt = hi;
        int i = lt;
        while(i<=hi){
            int comp = a[i].compareTo(pivot);

            if(comp<0) exch(a,lt++,i++);
            else if(comp > 0) exch(a,gt--,i);
            else i++;
        }

        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static String showArray(Comparable[] a){
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        Integer[] a = {6,4,5,4,4,6,6,5};
        sort(a);
        System.out.println(Arrays.toString(a));

}
    }

    


