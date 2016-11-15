package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static class LinkedListNode {
        int val;
        LinkedListNode next;

        public LinkedListNode(int k) {
            val = k;
            next = null;
        }
    }

    static LinkedListNode easyFindKth(LinkedListNode head, int k) {
        int count = 0;

        LinkedListNode temp = head;

        while (temp != null) {
            ++count;
            temp = temp.next;
        }

        temp = head;

        for (int ite = 0; ite < count - k; ++ite) {
            temp = temp.next;
        }

        return temp;

    }

    static int printFindKth(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        else {
            int index = printFindKth(head.next, k);
            index++;
            if (index == k) {
                System.out.println(head.val);
            }
            return index;
        }
    }

    static class Index {
        int val = 0;
    }

    static LinkedListNode recursiveFindKth(LinkedListNode head, int k, Index i) {
        if (head == null) {
            i.val = 0;
            return null;
        }
        else {
            LinkedListNode s = recursiveFindKth(head.next, k, i);
            i.val++;
            if (i.val == k) {
                return head;
            }
            return s;
        }
    }


}
