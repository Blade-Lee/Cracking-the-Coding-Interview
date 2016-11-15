package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[] test = {"","at"};

        System.out.println(search(test, "at"));
    }

    static int search(String[] input, String target) {
        if (input.length == 0 || input == null || target == null || target == "") {
            return -1;
        }
        else {
            return search(input, target, 0, input.length - 1);
        }

    }

    static int search(String[] input, String target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (input[mid].length() == 0) {
            int a = search(input, target, low, mid - 1);
            int b = search(input, target, mid + 1, high);
            return a == -1 ? b : a;
        }


        if (input[mid].compareTo(target) == 0) {
            return mid;
        }
        else if (input[mid].compareTo(target) < 0) {
            return search(input, target, mid + 1, high);
        }
        else {
            return search(input, target, low, mid - 1);
        }
    }
}
