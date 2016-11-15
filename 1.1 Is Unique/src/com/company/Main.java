package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String test = "";

        System.out.println(allUniqueSort(test));
    }

    static boolean allUnique(String str) {
        int counter = 0; // Assumption: no more than 32 unique characters
        char[] temp = str.toCharArray();
        for (char c: temp) {
            if ((1 << c -'a' & counter) != 0) {
                return false;
            }
            else {
                counter |= 1 << c - 'a';
            }
        }
        return true;
    }

    static boolean allUniqueSort(String str) {
        char[] temp = str.toCharArray(); // For the ease of implementation

        QuickSort(0, temp.length - 1, temp);

        for (int i = 0; i < temp.length - 1; ++i) {
            if (temp[i] == temp[i+1]) return false;
        }
        return true;
    }

    static void QuickSort(int start, int end, char[] arr) {

        if (start >= end) return;

        int mid = (start + end) / 2;
        int head = start;
        int tail = end;

        while (head < tail) {
            while (head < tail && arr[head] <= arr[mid]) head++;
            while (tail > head && arr[tail] >= arr[mid]) tail--;
            if (head >= tail) break;
            else {
                char temp = arr[head]; // Additional space required, but just one byte
                arr[head] = arr[tail];
                arr[tail] = temp;
            }
        }

        QuickSort(start, mid, arr);
        QuickSort(mid + 1, end, arr);
    }
}
