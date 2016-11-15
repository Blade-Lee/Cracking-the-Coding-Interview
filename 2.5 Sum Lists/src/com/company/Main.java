package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static LinkedListNode sumList(LinkedListNode a, LinkedListNode b) {
        int carry = 0;

        LinkedListNode result_head = new LinkedListNode(-1);
        LinkedListNode result_tail = result_head;

        while (a != null || b != null || carry != 0) {
            int temp = carry;
            if (a != null) {
                temp += a.val;
                a = a.next;
            }
            if (b != null) {
                temp += b.val;
                b = b.next;
            }
            carry = temp / 10;
            result_tail.next = new LinkedListNode(temp % 10);
            result_tail = result_tail.next;
        }

        return result_head.next;
    }
}
