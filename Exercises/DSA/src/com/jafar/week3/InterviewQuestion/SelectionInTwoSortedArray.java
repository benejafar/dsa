package com.jafar.week3.InterviewQuestion;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;



public class SelectionInTwoSortedArray {

    public static int selection(int ar1[], int ar2[], int k){
        // StdRandom.shuffle(ar1);
        // StdRandom.shuffle(ar2);
        int l = 0, h = ar1.length+ar2.length -1;
        while(h>l){
            int partIndex = partition(ar1, ar2, l, h);
            if (partIndex<k) {
                l = partIndex + 1;
            }else if (partIndex > k) {
                h = partIndex - 1;
            }else if(partIndex == k){
                return get(ar1, ar2, k);
            }
        }
        return get(ar1, ar2, k);

    }

    public static int partition(int ar1[], int ar2[], int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true){
            while(less(ar1, ar2, ++i, lo))
                if(i == hi) break;
            while(less(ar1, ar2, lo, --j))
                if(j == lo) break;
            
            if(i>=j) break;
            exch(ar1, ar2, i, j);
        }
        exch(ar1, ar2, j, lo);

        return j;
    }

    public static Integer get(int[] ar1, int[] ar2, int index) {
        if (index >= (ar1.length + ar2.length)) {
            throw new ArrayIndexOutOfBoundsException("index is more than the sum of two arrays length");
        }
        if (index < ar1.length) {
            return ar1[index];
        } else
            return ar2[index - ar1.length];
    }

    public static void set(int[] ar1, int[] ar2, int index, int item) {
        if (index >= (ar1.length + ar2.length)) {
            throw new ArrayIndexOutOfBoundsException("index is more than the sum of two arrays length");
        }
        if (index < ar1.length) {
            ar1[index] = item;
        } else
            ar2[index - ar1.length] = item;
    }

    public static boolean less(int[] ar1, int[] ar2, int i, int j) {
        return get(ar1, ar2, i).compareTo(get(ar1, ar2, j)) < 0;
    }

    public static void exch(int[] ar1, int[] ar2, int i, int j) {
        int temp = get(ar1, ar2, i);
        set(ar1, ar2, i, get(ar1, ar2, j));
        set(ar1, ar2, j, temp);
    }

    public static String showArray(int[] arr) {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] ar1 = { 0, 1, 2 };
        int[] ar2 = { 3, 4, 5 };
        // checking get
        System.out.println(get(ar1, ar2, 5));
        // System.out.println(get(ar1, ar2, 6));

        // set method
        set(ar1, ar2, 3, 10);
        System.out.println(ar2[0]);
        set(ar1, ar2, 2, 5);
        System.out.println(ar1[2]);

        // less
        boolean isLess = less(ar1, ar2, 0, 3);
        System.out.println(isLess);

        // exhange
        exch(ar1, ar2, 0, 3);
        System.out.println(ar2[0]);
        System.out.println(ar1[0]);

        int[] ar3 = { 15,19, 2, 5 };
        int[] ar4 = { 7, 18 };
        int p = partition(ar3, ar4, 0, 5);
        System.out.println(p);
        System.out.println(Arrays.toString(ar3));
        System.out.println(Arrays.toString(ar4));

        Stopwatch timer = new Stopwatch();
        int a[] = {2,12,9};
        int b[] = {10,5,7};
        System.out.println(selection(a, b, 4));
        System.out.println(timer.elapsedTime());

    }

}
