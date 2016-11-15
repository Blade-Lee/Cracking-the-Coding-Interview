package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String test = "1a1b2baca234";

        System.out.println(check(test));
        System.out.println(bitCheck(test));

    }

    public static boolean check(String str) {

        // Only letters and space
        // no case sensitive
        int[] count = new int[128];
        int odd_count = 0;

        for (char c:str.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }
            if (!('a' <= c && c <= 'z')) {
                continue;
            }
            if (++count[c] % 2 == 1) {
                odd_count++;
            }
            else {
                odd_count--;
            }

        }

        return (odd_count <= 1);
    }

    public static boolean bitCheck(String str) {
        int bitVector = 0;

        for (char c:str.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }
            if (!('a' <= c && c <= 'z')) {
                continue;
            }

            int temp = 1 << (c - 'a');

            if ((bitVector & temp) != 0) {
                bitVector &= ~temp;
            }
            else {
                bitVector |= temp;
            }
        }

        return  ((bitVector - 1) & bitVector) == 0;
    }
}
