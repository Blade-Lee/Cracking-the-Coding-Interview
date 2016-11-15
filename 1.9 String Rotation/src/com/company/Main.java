package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        waterbottlewaterbottle
    }

    static boolean isRotation(String a, String b) {

        if (a.length() != b.length()) return false;

        StringBuilder test = new StringBuilder(2 * a.length());

        test.append(a);
        test.append(a);

        return String.isSubstring(test.toString(), b);
    }
}
