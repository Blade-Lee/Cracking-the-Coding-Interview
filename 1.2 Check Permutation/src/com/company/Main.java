package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String test = "";
        String haha = "12";
        System.out.println(Count(test, haha));
    }

    public static boolean Count(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        // Assumption: not case sensitive
        // Using ASCII Coding
        // whitespace counts
        int[] count = new int[128];

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        for (char c: arr1) {
            count[c]++;
        }

        for (char c:arr2) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
