package com.jafar.week3.mergesort;

import java.util.Arrays;
import java.util.List;

import com.jafar.week3.bottomupmergesort.MergeBottomUp;

public class TestMergeSort {

    public static void main(String[] args) {


        Integer[] arr = new Integer[]{11,25,9,13,2};
        MergeBottomUp.sort(arr);
        arPrint(arr);
    }

    public static void arPrint(Integer[ ] arr)
    {

        System.out.println(Arrays.asList(arr));
    }
    
}
