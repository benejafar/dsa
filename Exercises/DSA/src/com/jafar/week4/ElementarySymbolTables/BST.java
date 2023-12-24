package com.jafar.week4.ElementarySymbolTables;

import java.util.ArrayList;
import java.util.List;

import javax.management.QueryEval;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else
            x.val = val;
        // for including count
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null)
            return 0;
        return x.count;
    }

    public Value get(Key key) {

        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        else
            return x.key;
    }

    public Node floor(Node x, Key key) {

        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        else if (cmp < 0)
            return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null)
            return;

        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> q = new Queue<>();
        levelOrder(root, q);
        return q;
    }

    // assignment question
    // breadth first search
    private void levelOrder(Node x, Queue<Key> q) {
        Queue<Node> orderedQueue = new Queue<>();
        orderedQueue.enqueue(x);
        while (orderedQueue.size() > 0) {
            int ordQueueLen = orderedQueue.size();
            for (int i = 0; i < ordQueueLen; i++) {
                Node pop = orderedQueue.dequeue();
                q.enqueue(pop.key);
                if (pop.left != null) {
                    orderedQueue.enqueue(pop.left);
                }
                if (pop.right != null) {
                    orderedQueue.enqueue(pop.right);
                }

            }
        }
    }

    // to delete minimum key
    public void delMin() {
        root = delMin(root);
    }

    // delete min and return the root with updated count
    private Node delMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = delMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    // to delete a key
    public void delete(Key key) {
        root = delete(root, key);
    }

    // private Node delete(Node x, Key key){
    // if (x == null) return null;
    // int cmp = key.compareTo(x.key);
    // if (cmp < 0) x.left = delete(x.left, key);
    // else if (cmp > 0) x.right = delete(x.right, key);
    // else {
    // if (x.right == null) return x.left;
    // if (x.left == null) return x.right;

    // Node t = x;
    // x = min(t.right);
    // x.right = delMin(t.right);
    // x.left = t.left;
    // }
    // x.count = size(x.left) + size(x.right) + 1;
    // return x;
    // }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.left == null)
                return x.right;
            if (x.right == null)
                return x.left;

            // if node have two children
            Node t = x;
            x = min(t.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    // assignment question 2
    private boolean isBST(Node root, Node min, Node max) {

        if (root == null)
            return true;

        if (min != null && min.key.compareTo(root.key) >= 0) {
            return false;
        }
        if (max != null && root.key.compareTo(max.key) >= 0) {
            return false;
        }

        return (isBST(root.left, min, root) && isBST(root.right, root, max));
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        bst.put("S", 0);
        bst.put("E", 1);
        bst.put("A", 2);
        bst.put("C", 3);
        bst.put("R", 4);
        bst.put("H", 5);
        bst.put("M", 7);
        bst.put("X", 8);

        System.out.println(bst.isBST());

        // Iterable<String> inorder = bst.levelOrder();

        // for(String s : inorder){
        // System.out.print(s + ", ");
        // }

        // List<Integer> a = new ArrayList<>();

        // for (String s : bst.keys()){System.out.print(s+", ");}
        // bst.delete("E");
        // System.out.println();
        // for (String s : bst.keys()){System.out.print(s+", ");}
        // System.out.println();

        // System.out.println(bst.floor("G"));

        // Iterable<String> itr = bst.levelOrder();

        // for (String s : itr) {
        // System.out.print(s + ", ");
        // }
        // System.out.println();

        // bst.delMin();

        // Iterable<String> itr1 = bst.levelOrder();

        // for (String s : itr1) {
        // System.out.print(s + ", ");
        // }
        // System.out.println();

        // for (String s : bst.keys()){
        // System.out.print(s + ", ");
        // }

    }

}