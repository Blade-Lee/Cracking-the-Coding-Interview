package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (int i = 1; i < 1000; ++i) {
            System.out.format("i:%d, ways:%d\n", i, with_1(i));
        }
    }

    static int with_1(int x) {
        int result = 1;
        for (int i = 5; x - i >= 0; i += 5) {
            result += with_5(i);
        }
        return result;
    }

    static int with_5(int x) {
        int result = 1;
        for (int i = 10; x - i >= 0 && (x - i) % 5 == 0; i += 10) {
            result += with_10(i);
        }
        return result;
    }

    static int with_10(int x) {
        int result = 1;
        for (int i = 25; x - i >= 0 && (x - i) % 10 == 0; i += 25) {
            result += 1;
        }
        return result;
    }
}
