package com.sher.tree;


import java.util.*;

/**
 * Print a Binary Tree in Vertical Order
 * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 */
public class PrintBTVertical {
    public static void main(String arg[]) {
        Node root = BTreePrinter.tree1();
        BTreePrinter.printNode(root);
        System.out.println("--");
        printVertical(root);
    }

    private static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static void printVertical(Node root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();

        Queue<Pair> que = new LinkedList<Pair>();
        Pair pRoot = new Pair(root,  0);
        que.add(pRoot);
        Pair p = null;
        int minHd = 0, maxHd = 0;
        while (!que.isEmpty()) {
            //p = que.peek();
            p = ((LinkedList<Pair>) que).pop();
            int hd = p.hd;
            minHd  = Math.min(minHd, hd);
            maxHd  = Math.max(maxHd, hd);

            if (map.containsKey(p.hd)) {
               map.get(hd).add(p);
            } else {
                List<Pair> list = new LinkedList<Pair>();
                map.put(hd, list);
                list.add(p);
            }

            if (p.node.left != null)
              ((LinkedList<Pair>) que).add(new Pair(p.node.left, hd - 1));

            if (p.node.right != null)
                ((LinkedList<Pair>) que).add(new Pair(p.node.right, hd + 1));
        }

        for (int i = minHd; i <= maxHd; i++) {
            List<Pair> list = map.get(i);
            for (Pair pp:list) {
                System.out.print(pp.node.data + " ");
            }
            System.out.println("");
        }

    }
}
