import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    private int n;
    private Node firstElement;
    private Node lastElement;

    private class Node {
        public Item item;
        public Node next;
        public Node previos;
    }

    public Deque() {
        n = 0;
        firstElement = null;
        lastElement = null;
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public int size() {
        return n;
    }

    public void addFirst(Item newItem) {
        if (newItem == null) {
            throw new IllegalArgumentException();
        }
        Node elem = new Node();
        elem.item = newItem;
        elem.next = null;
        elem.previos = null;
        if (n == 0) {
            firstElement = elem;
            lastElement = elem;
            n += 1;
        } else {
            Node oldFirst = firstElement;
            firstElement = elem;
            firstElement.next = oldFirst;
            oldFirst.previos = firstElement;
            n += 1;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node elem = new Node();
        elem.item = item;
        elem.next = null;
        if (n == 0) {
            firstElement = elem;
            lastElement = elem;
            n += 1;
        } else {
            Node oldLastElement = lastElement;
            oldLastElement.next = elem;
            elem.previos = oldLastElement;
            lastElement = elem;
            n += 1;
        }
    }

    public Item removeFirst() {
        if (n > 0) {
            Node elem = firstElement;
            firstElement = firstElement.next;
            if (firstElement != null) {
                firstElement.previos = null;
            }
            n -= 1;
            return elem.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Item removeLast() {
        if (n > 0) {
            Node oldLast = lastElement;
            lastElement = lastElement.previos;
            if (lastElement != null) {
                lastElement.next = null;
            }
            n -= 1;
            return oldLast.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        Node currElem = firstElement;

        @Override
        public boolean hasNext() {
            return currElem != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = currElem.item;
            currElem = currElem.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        deque.addFirst("apple");
        deque.addLast("mango");
        deque.addFirst("marshmellow");
        deque.addFirst("lemon");
        deque.addFirst("tomato");
        StdOut.println(deque.size());
        Iterator<String> itr = deque.iterator();
        while (itr.hasNext()) {
            StdOut.println(itr.next());
        }
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());

    }

}
