package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }


    public static class LinkedListNode {

        int val;
        LinkedListNode next;

        public LinkedListNode(int n) {
            val = n;
            next = null;
        }
    }


    public static void removeDups(LinkedListNode list) {
        HashSet<Integer> count = new HashSet<>();

        LinkedListNode previous = null;

        while (list != null) {
            if (count.contains(list.val)) {
                previous.next = list.next;
            }
            else {
                count.add(list.next.val);
                previous = list;
            }
            list = list.next;
        }
    }

    public static void removeDupsNoBuffer(LinkedListNode list) {
        LinkedListNode current = list;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
