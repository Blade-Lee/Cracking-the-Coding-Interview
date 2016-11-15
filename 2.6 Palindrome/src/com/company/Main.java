package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static boolean findPalindrome(LinkedListNode head) {

        int count = 0;
        LinkedListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            ++count;
        }

        int mid_index = count % 2 == 0 ? count / 2 : count / 2 - 1;

        LinkedListNode reverse_head = null;
        temp = head;

        while (mid_index-- >= 0) {
            LinkedListNode te = new linkedListNode(temp.val);
            te.next = reverse_head;
            reverse_head = te;
            temp = temp.next;
        }

        if (count % 2 == 1) {
            temp = temp.next;
        }

        while (temp != null && reverse_head != null) {
            if (temp.val != reverse_head.val) {
                return false;
            }
            temp = temp.next;
            reverse_head = reverse_head.next;
        }

        return true;
    }
}
