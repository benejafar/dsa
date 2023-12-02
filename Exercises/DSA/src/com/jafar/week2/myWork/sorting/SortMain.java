package com.jafar.week2.myWork.sorting;

import java.util.Arrays;

public class SortMain {
    

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{32,56,4,13,27,84};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
