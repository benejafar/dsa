package com.jafar.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings<Item> implements Iterable<Item>{

    private Item[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity){
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
        s[N++] = item;
    }

    public Item pop(){
        return s[--N];
    }

    public Item[] getS() {
        return s;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }
    }
}


