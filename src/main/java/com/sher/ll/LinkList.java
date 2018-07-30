package com.sher.ll;


public class LinkList {
    public Node head;
    private Node tail;

    public LinkList (int arr[]) {
        build(arr);
    }
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private void build(int arr[]) {
        Node n;
        for (int i: arr) {
            n = new Node(i);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = tail.next;
            }
        }

    }


    public static void main(String arg[]) {
        //2->3->5->3>2; //right shift by 3 should be
        //5->3->2->2->3
        int arr[] = {2, 3, 5, 3, 3};
        LinkList n = new LinkList(arr);
        System.out.println(n);
    }

    @Override
    public String toString() {
        String result = "";
        Node current = head;
        while(current != null){
            result += current.data + ", ";
            current = current.next;
        }
        return "List: " + result;
    }
}
