package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "aabcccccaaa";
        System.out.println(compress(input));
    }

    static String compress(String str) {

        StringBuilder result = new StringBuilder(str.length());

        int count = 0;

        for (int i = 0; i < str.length(); ++i) {
            count++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                result.append(str.charAt(i));
                result.append(count);
                count = 0;
            }
        }

        return str.length() < result.length() ? str : result.toString();
    }
}
