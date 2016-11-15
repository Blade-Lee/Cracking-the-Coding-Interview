package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static boolean loopDetection(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;


        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        int x = 0;

        do {
            fast = fast.next.next;
            slow = slow.next;
            ++x;
        } while (fast != slow);

        fast = head;
        slow = head;

        while (x-- > 0) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
