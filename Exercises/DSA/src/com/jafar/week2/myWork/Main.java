package com.jafar.week2.myWork;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ResizingArrayQueue raq = new ResizingArrayQueue(2);
        raq.enqueue("apple");
        raq.enqueue("banana");
        raq.enqueue("orange");
        raq.enqueue("mango");
        System.out.println(raq.dequeue());
        raq.enqueue("strawberry");
        System.out.println(Arrays.toString(raq.getQ()));
    }
}
