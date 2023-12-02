package com.jafar.week2.sorting;

import java.util.Arrays;

public class SelectionSort {
    
    public Integer[] sort(Integer[] a){

        int i = 0 ;
        int N = a.length;
        while(i < N){
            int min = i;
            for (int j = i+1; j < N ; j++){
                if(less(a[j],a[min])) min = j;
            }
            exch(a, i, min);
            i++;
        }
        return a;
    }
    

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        Integer[] a = selectionSort.sort(new Integer[]{52,41,34,21,13,8});
        System.out.println(Arrays.asList(a));

    }
}
