package com.jafar.week2.myWork.sorting;

import java.util.Arrays;

public class InsertionSort {
    
    public void sort(Integer[] a){

        for (int i = 0 ; i < a.length ; i++){
            for(int j = i ; j > 0 ; j--){
                if(less(a[j],a[j-1])){
                    exch(a, j, j-1);
                }
            }
        }
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
        InsertionSort insertionSort = new InsertionSort();
        Integer[] arr = new Integer[]{5,4,5,2,3,65,32,1};
        insertionSort.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
