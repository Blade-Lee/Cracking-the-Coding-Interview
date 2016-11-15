package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class AnagramComparator implements Comparator<String> {

        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }

        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }
    }
}
