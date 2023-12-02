package com.jafar.week2.myWork;

import edu.princeton.cs.algs4.Stack;

public class StackWithMax {

    Stack<Double> trackStack = new Stack<>();
    Stack<Double> numStack = new Stack<>();

    public void push(Double num){
        if(numStack.size() == 0){
            numStack.push(num);
            trackStack.push(num);
        }else{
            Double firstNum = trackStack.peek();
            numStack.push(num);
            if(firstNum > num){
                trackStack.push(firstNum);
            }else {
                trackStack.push(num);
            }
        }
    }

    public Double pop(){
        trackStack.pop();
        return numStack.pop();
    }

    public Double max(){
        return trackStack.peek();
    }

    //test client

    public static void main(String[] args) {
        StackWithMax stackWithMax = new StackWithMax();
        stackWithMax.push(5.0);
        stackWithMax.push(4.0);
        stackWithMax.push(3.5);
        stackWithMax.push(100.00);
        stackWithMax.push(55.0);
        stackWithMax.push(0.0);

        System.out.println(stackWithMax.max());
    }
}
