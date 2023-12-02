package com.jafar.week3.InterviewQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecimalDominants{
    public static List<Integer> finder(int[] ar, int k){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> elementCountMorethanK = new ArrayList<>();


        for(int i : ar){
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else if (!map.containsKey(i)) {
                map.put(i, 1);
            }
            
        }
        
        for(Map.Entry<Integer,Integer> item : map.entrySet()){
            if (item.getValue() >= k) elementCountMorethanK.add(item.getKey());
        }

        return elementCountMorethanK;

    }

    public static void main(String[] args) {
        int[] a = {1,1,3,2,1,2,6,4,2,2,1,1,4,2,12,12,5,3,2,4};
        DecimalDominants decimalDominants = new DecimalDominants();
        for(int i : decimalDominants.finder(a, 3)){
            System.out.println(i);
        }
    }
}