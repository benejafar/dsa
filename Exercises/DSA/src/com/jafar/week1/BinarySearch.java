package com.jafar.week1;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key){
        int lo = 0, hi = arr.length -1;

        while(hi>=lo){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > key){
                hi = mid-1;
            }
            else if(arr[mid] < key){
                lo = mid+1;
            }else return mid;
        }
        return -1;
    }
}
