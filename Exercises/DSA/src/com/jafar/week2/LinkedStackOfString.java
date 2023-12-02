package com.jafar.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStackOfString<Item> implements Iterable<Item>{

    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedStackOfString linkedList = new LinkedStackOfString();
        linkedList.push("apple");
        System.out.println(linkedList.pop());
    }

    public Iterator<Item> iterator(){
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current  = current.next;
            return item;
        }
    }
}


