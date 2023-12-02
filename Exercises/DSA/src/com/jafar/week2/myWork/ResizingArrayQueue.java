package com.jafar.week2.myWork;

public class ResizingArrayQueue {

    private String[] q;
    private int front;
    private int last;
    private int n;

    public String[] getQ() {
        return q;
    }

    public ResizingArrayQueue(int size){
        q = new String[size];
        front = 0;
        last = 0;
        n = 0;
    }

    public void enqueue(String item){
        if (n == q.length) resize(2*q.length);
        if(last == q.length) last = 0;
        q[last++] = item;
        n++;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < n ; i++){
            copy[i] = q[(front+i)%q.length];
        }
        q = copy;
        front = 0;
        last = n;
    }

    public String dequeue(){
        if(q[front] == null) return "empty queue";
        String item = q[front];
        q[front] = null;
        front ++;
        n--;
        if(front == q.length) front = 0;
        return item;
    }



}
