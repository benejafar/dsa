import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int first;
    private int last;
    private int size;

    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        first = 0;
        last = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (size == queue.length)
            resize(2 * queue.length);
        if (last == queue.length)
            last = 0;
        queue[last++] = item;
        size += 1;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size > 0 && size == queue.length / 4)
            resize(queue.length / 2);
        // if(first == queue.length) first = 0;
        // Item elem = queue[first];
        // queue[first++] = null;
        // size -- ;
        // return elem;

        int randInt = StdRandom.uniformInt(0, size);
        int index = (first + randInt) % queue.length;
        Item elem = queue[index];
        if (last == 0) {
            last = queue.length;
        }
        queue[index] = queue[--last];
        queue[last] = null;
        size--;
        return elem;

    }

    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int randInt = StdRandom.uniformInt(0, size);
        int index = (first + randInt) % queue.length;
        return queue[index];

    }

    private void resize(int c) {

        Item[] copy = (Item[]) new Object[c];
        for (int i = 0; i < size; i++) {
            copy[i] = queue[(first + i) % queue.length];
        }
        queue = copy;
        first = 0;
        last = size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>{
        private final RandomizedQueue<Item> copy;

        public RandomizedQueueIterator(){
            copy = new RandomizedQueue<>();
            for(int i = 0 ; i < size() ; i ++ ){
                copy.enqueue(queue[(first + i) % queue.length]);
            }
        }

        @Override
        public boolean hasNext(){
            return copy.size() > 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("there are no more elements");
            return copy.dequeue();
        }

        public void remove(){
            throw new UnsupportedOperationException("this is not supported by this class");
        }
        
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        StdOut.println(randomizedQueue.isEmpty());
        randomizedQueue.enqueue("mango");
        randomizedQueue.enqueue("strawberry");
        randomizedQueue.enqueue("jackfruit");
        randomizedQueue.enqueue("pomegranate");
        randomizedQueue.enqueue("apple");
        randomizedQueue.enqueue("cucumber");
        StdOut.println(randomizedQueue.size());
        StdOut.println(randomizedQueue.dequeue());
        StdOut.println(randomizedQueue.sample());
        
        Iterator<String> itr = randomizedQueue.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
            // itr.remove();
        }
    }
}
