package com.jafar.week5.balanced_search_trees;

import edu.princeton.cs.algs4.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Queue<Integer> i ;
        Key key;
        Value val;
        Node left, right;
        boolean color; // color of the parent link

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }

    }

    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
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

    // Orient a (temporary) right leaning red link to left lean

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Orient left leaning red link for temporarily leaning right
    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Recolor to split a temporary 4 node
    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.right);
        assert isRed(h.left);
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }

    // INSERTION IN LEFT LEAN RED BLACK TREE
    public Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else
            h.val = val;

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.right) && isRed(h.left))
            flipColors(h);

        return h;
    }

}
