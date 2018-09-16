package com.sher.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BottomUpPrint {
    public static void main(String arg[]) {
        Node n1 = new Node(3);
        Node n9 = new Node(9);
        Node n20 = new Node(20);
        n1.left = n9;
        n1.right = n20;

        Node n15 = new Node(15);
        Node n7 = new Node(7);
        n20.left = n15;
        n20.right = n7;

        BTreePrinter.printNode(n1);
        printBottomUp(n1);
    }

    //Broken, fix it
    static void printBottomUp(Node root) {
        Node dummy =  new Node(Integer.MIN_VALUE);
        Queue<Node> que = new LinkedList<Node>();
        Stack<Node> s =  new Stack<Node>();
        ((LinkedList<Node>) que).push(root);
        while (que.isEmpty() == false) {
            Node n = ((LinkedList<Node>) que).pop();
            s.push(n);
            //System.out.println(n.data);

            if (n.right != null)
            ((LinkedList<Node>) que).add(n.right);

            if (n.left != null)
                ((LinkedList<Node>) que).add(n.left);
        }

        while (s.isEmpty() == false){
           System.out.println(s.pop().data);
        }
    }
}
