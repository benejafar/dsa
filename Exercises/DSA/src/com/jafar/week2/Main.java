package com.jafar.week2;

import com.jafar.week2.myWork.ResizingArrayQueue;
import com.sun.source.tree.LiteralTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        FixedCapacityStackOfStrings<String> fixedCapacityStackOfString = new FixedCapacityStackOfStrings<>(8);
        fixedCapacityStackOfString.push("audi");
        fixedCapacityStackOfString.push("bmw");
        fixedCapacityStackOfString.push("farrari");
        fixedCapacityStackOfString.push("lamborgini");

        Iterator<String> itr = fixedCapacityStackOfString.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

//        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
//        stack.push("apple");
//        stack.push("banana");
//        System.out.println(Arrays.toString(stack.getS()));

//        ResizingCapacityStackOfStrings stack = new ResizingCapacityStackOfStrings();
//        stack.push("apple");
//        stack.push("mango");
//        stack.push("banana");
//        stack.push("beetroot");
//        stack.push("onion");
//        System.out.println(Arrays.toString(stack.getS()));
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(Arrays.toString(stack.getS()));

//        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
//        queue.enqueue("apple");
//        queue.enqueue("banana");
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());

//        int[] arr = new int[5];
//        arr[0] = 1;
//        System.out.println(arr.length);

//        com.jafar.week2.myWork.ResizingArrayQueue raq = new ResizingArrayQueue(2);
//        raq.enqueue("apple");
//        raq.enqueue("banana");
//        raq.enqueue("orange");
//        raq.enqueue("mango");
//        System.out.println(raq.dequeue());
//        raq.enqueue("strawberry");
//        System.out.println(Arrays.toString(raq.getQ()));


//        LinkedStackOfString<String> linkedStackOfString = new LinkedStackOfString<>();
//        linkedStackOfString.push("apple");
//        linkedStackOfString.push("mango");
//        linkedStackOfString.push("tomato");
//
//        for(String s : linkedStackOfString){
//            System.out.println(s);
//        }

    }
}
