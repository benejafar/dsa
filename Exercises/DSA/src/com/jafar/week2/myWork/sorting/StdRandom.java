package com.jafar.week2.myWork.sorting;

import java.util.Arrays;

public class StdRandom {

    public static Integer[] shuffle(Integer[] a){

        int N = a.length;
        for(int i = 0  ; i < N ; i++ ){
            int r = edu.princeton.cs.algs4.StdRandom.uniformInt(i+1);
            exch(a,i,r);
        }
        return a;
    }

    public static void exch(Comparable[] a,int b, int c){
        Comparable tem = a[b];
        a[b] = a[c];
        a[c] = tem;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,2,3,23,43,12,83,61};
        System.out.println(Arrays.asList(shuffle(arr)));

    }
    
}
