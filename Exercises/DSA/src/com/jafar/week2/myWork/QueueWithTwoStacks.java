package com.jafar.week2.myWork;

import edu.princeton.cs.algs4.Stack;

public class QueueWithTwoStacks {

    Stack<String> inputStack = new Stack<>();
    Stack<String> outputStack = new Stack<>();

    public void enqueue(String input){
        inputStack.push(input);
    }

    public String dequeue(){
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());}
        }
        return outputStack.pop();
    }

    public boolean isEmpty(){
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enqueue("apple");
        queueWithTwoStacks.enqueue("mango");
        queueWithTwoStacks.dequeue();
        queueWithTwoStacks.enqueue("Strawberry");
        queueWithTwoStacks.enqueue("Cherry");
        while(!queueWithTwoStacks.isEmpty()){
            System.out.println(queueWithTwoStacks.dequeue());
        }
    }
}
