package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    static LinkedListNode partitoin(LinkedListNode head, int x) {
        LinkedListNode less_head = new LinkedListNode(-1);
        LinkedListNode greater_head = new LinkedListNode(-1);
        LinkedListNode less_tail = less_head;
        LinkedListNode greater_tail = greater_head;


        LinkedListNode temp = head;
        LinkedListNode temp2 = null;

        while (temp != null) {
            if (temp.val < x) {
                less_tail.next = temp;
                less_tail = less_tail.next;
            }
            else {
                greater_tail.next = temp;
                greater_tail = greater_tail.next;
            }
            temp = temp.next;
        }

        less_tail.next = greater_head.next;
        greater_tail.next = null;

        return less_head.next;
    }
}
