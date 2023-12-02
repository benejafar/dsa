//package com.jafar.week2;
//
//import java.util.Iterator;
//
//public class Stack<Item> implements Iterable<Item> {
//    ...
//    @Override
//    public Iterator<Item> iterator() {
//        return new ListIterator();
//    }
//
//    private class ListIterator implements Iterator<Item>{
//        private Node current = first;
//
//        public boolean hasNext(){return current != null;}
//        public void remove() {}
//        public Item next(){
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//    }
//}
