package com.sher.ds.ll;

//import static com.sher.ds.LinkList.Node;
import static com.sher.ds.ll.LinkList.Node;

public class RightShift {

    private Node rightShift(Node head, int shiftBy) {
       int count = 0;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;
        int newTailIndex = count - shiftBy;
        tail = head;
        while(newTailIndex != 0) {
            newTailIndex --;
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    public static void main(String arg[]) {
        RightShift r  = new RightShift();
        //2->3->5->3>2; //right shift by 3 should be
        //5->3->2->2->3
        int arr[] = {2, 3, 5, 3, 3};
        LinkList n = new LinkList(arr);
        System.out.println(n);
        n.head = r.rightShift(n.head, 3);

        System.out.print("RightShift" + n);
    }

}
