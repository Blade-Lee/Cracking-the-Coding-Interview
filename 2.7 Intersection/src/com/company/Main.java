package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static boolean intersection (LinkedListNode a, LinkedListNode b) {

        int countA = 0;
        int countB = 0;

        LinkedListNode temp = a;

        while (temp != null) {
            ++countA;
            temp = temp.next;
        }

        temp = b;

        while (temp != null) {
            ++countB;
            temp = temp.next;
        }

        temp = countA > countB ? a : b;
        LinkedListNode temp2 = countA > countB ? b : a;

        int k = countA - countB;

        while (k-- > 0) {
            temp = temp.next;
        }

        while (temp != null && temp2 != null) {
            if (temp == temp2) {
                return true;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return false;
    }
}
