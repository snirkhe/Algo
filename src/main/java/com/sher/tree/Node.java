package com.sher.tree;

public class Node {
    public int data;
    public Node left, right;

    public Node (int data) {
        this.data = data;
    }

    public void addLeft(Node l) {
        this.left = l;
    }

    public void addRight(Node r) {
        this.right =  r;
    }

    public Node add(int v) {
        Node n = new Node(v);
        return add(n);
    }

    public Node add(Node c) {
        if (c == null) return this;
        if (data >= c.data) {
            if (left == null) {
                left = c;
            } else {
                left.add(c);
            }
        } else {
            if (right == null) {
                right = c;
            } else {
                right.add(c);
            }
        }
        return this;
    }
}
