package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static class Listy {
        int elementAt(int s) {
            return 0;
        }
    }

    static int search(Listy input, int x) {
        int end = 0;
        int step = 1;

        while (step != 0) {
            if (input.elementAt(end) == x) {
                return end;
            }
            while (input.elementAt(end + step) != -1 &&
                    input.elementAt(end + step) < x) {
                step *= 2;
            }
            while (input.elementAt(end + step) == -1 ||
                    input.elementAt(end + step) > x) {
                step /= 2;
            }
            end += step;
        }
    }

    static int binarySearchStart(Listy list, int value) {
        int index = 1;

        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }

        return binarySearch(list, value, index / 2, index);

    }

    static int binarySearch(Listy list, int value, int low, int high) {

        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (list.elementAt(mid) > value || list.elementAt(mid) == -1) {
                high = mid - 1;
            }
            else if (list.elementAt(mid) < value) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
    }
}
