package com.sher.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class BTreePrinterTest {
//
//    private static Node test1() {
//        Node root = new Node(2);
//        Node n11 = new Node(7);
//        Node n12 = new Node(5);
//        Node n21 = new Node(2);
//        Node n22 = new Node(6);
//        Node n23 = new Node(3);
//        Node n24 = new Node(6);
//        Node n31 = new Node(5);
//        Node n32 = new Node(8);
//        Node n33 = new Node(4);
//        Node n34 = new Node(5);
//        Node n35 = new Node(8);
//        Node n36 = new Node(4);
//        Node n37 = new Node(5);
//        Node n38 = new Node(8);
//
//        root.left = n11;
//        root.right = n12;
//
//        n11.left = n21;
//        n11.right = n22;
//        n12.left = n23;
//        n12.right = n24;
//
//        n21.left = n31;
//        n21.right = n32;
//        n22.left = n33;
//        n22.right = n34;
//        n23.left = n35;
//        n23.right = n36;
//        n24.left = n37;
//        n24.right = n38;
//
//        return root;
//    }
//
//    private static Node test2() {
//        Node root = new Node(2);
//        Node n11 = new Node(7);
//        Node n12 = new Node(5);
//        Node n21 = new Node(2);
//        Node n22 = new Node(6);
//        Node n23 = new Node(9);
//        Node n31 = new Node(5);
//        Node n32 = new Node(8);
//        Node n33 = new Node(4);
//
//        root.left = n11;
//        root.right = n12;
//
//        n11.left = n21;
//        n11.right = n22;
//
//        n12.right = n23;
//        n22.left = n31;
//        n22.right = n32;
//
//        n23.left = n33;
//
//        return root;
//    }
//
//    public static void main(String[] args) {
//
//        BTreePrinter.printNode(test1());
//        BTreePrinter.printNode(test2());
//
//    }
//}
//
//// class Node<T extends Comparable<?>> {
////    Node left, right;
////    T data;
////
////    public Node(T data) {
////        this.data = data;
////    }
////}

public class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);
        System.out.println("");
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static  boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public static Node tree1() {
        Node root = new Node(2);
        Node n11 = new Node(7);
        Node n12 = new Node(5);
        Node n21 = new Node(2);
        Node n22 = new Node(6);
        Node n23 = new Node(3);
        Node n24 = new Node(6);
        Node n31 = new Node(1);
        Node n32 = new Node(8);
        Node n33 = new Node(4);
        Node n34 = new Node(5);
        Node n35 = new Node(8);
        Node n36 = new Node(9);
        Node n37 = new Node(5);
        Node n38 = new Node(10);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

}
