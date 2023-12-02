package com.jafar.week2;

public class ResizingCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingCapacityStackOfStrings(){
        s = new String[1];
    }

    public void push(String item){
        if(N == s.length) resize(2*s.length);
        s[N++] = item;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i = 0; i < N ; i++)
            copy[i] = s[i];
        s = copy;
    }

    public String pop(){
        String itm = s[--N]; // to prevent loitering
        s[N] = null;
        if(N > 0 && N == (s.length)/4) resize(s.length/4); //to prevent thrashing
        return itm;
    }

    public String[] getS() {
        return s;
    }
}
