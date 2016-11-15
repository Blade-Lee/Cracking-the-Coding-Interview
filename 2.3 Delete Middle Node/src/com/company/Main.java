package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static boolean deleteNode(LinkedListNode k) {
        if (k == null || k.next == null) {
            return false;
        }
        else {
            k.data = k.next.data;
            k.next = k.next.next;
            return true;
        }
    }
}
