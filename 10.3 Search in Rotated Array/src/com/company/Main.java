package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static int searchRotated(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;

        if (a[mid] == x) {
            return mid;
        }

        if (left > right) {
            return -1;
        }

        if (a[left] < a[mid]) { // left part is in order
            if (x >= a[left] && x < a[mid]) { // x in left part
                return searchRotated(a, left, mid - 1, x);
            }
            else {// x in right part
                return searchRotated(a, mid + 1, right, x);
            }
        }
        else if (a[left] > a[mid]) { // right part is in order
            if (x <= a[right] && x > a[mid]) { // x in right part
                return searchRotated(a, mid + 1, right, x);
            }
            else { // x in left part
                return searchRotated(a, left, mid - 1, x);
            }
        }
        else { //  mid == left
            if (a[left] != a[right]) { // left part is repeated
                // x will only in right part
                return searchRotated(a, mid + 1, right, x);
            }
            else { // left == mid == right
                // check both sides
                int result = searchRotated(a, left, mid - 1, x);
                if (result == -1) {// find nothing on the left
                    return searchRotated(a, mid + 1, right, x);
                }
                else {
                    return result;
                }
            }
        }
    }
}
