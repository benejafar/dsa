package com.jafar.week3.InterviewQuestion;

import java.io.*;
import java.util.Arrays;


//selection in two sorted sub array
class GFG {
	
    public static int find(int[] A, int[] B, int m, int n, int k_req ){
        int k = 0, i = 0 , j  = 0;
        while( i < m && j < n){
            while(A[i] < B[j]){
                k ++ ; 
                if(k == k_req){
                    return A[i];
                }
                i ++;
            }

            while(B[j] < A[i]){
                k++;
                if(k  == k_req){
                    return B[j];
                }
                j ++ ; 
            }
        }

        while ( i < m ){
            k++;
            if(k == k_req) return A[i];
            i ++;
        }

        while( j < m ){
            k ++ ;
            if(k == k_req) return B[j];
            j++;
        }

        return -1;
    }

    public static String  showArray(int[] arr){
        return Arrays.toString(arr);
    }

	// Driver Code
	public static void main(String[] args)
	{
		int[] A = { 2, 3, 6, 7 };
		int[] B = { 1, 4, 8 };
		int k = 5;

		System.out.println(find(A, B, 4, 3, k));
	}
}
