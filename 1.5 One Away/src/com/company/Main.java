package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String test = "abcf";
        String haha = "bcf";

        System.out.println(isOneAway(test, haha));
    }

    static boolean isOneAway(String str1, String str2) {
        char[] tmp1 = str1.toCharArray();
        char[] tmp2 = str2.toCharArray();

        int[][] ED = new int[tmp1.length + 1][tmp2.length + 1];

        for (int x = 0; x < tmp1.length + 1; ++x) {
            for (int y = 0; y < tmp2.length + 1; ++y) {
                if (x == 0 && y == 0) {
                    ED[x][y] = 0;
                }
                else if (x != 0 && y == 0) {
                    ED[x][y] = x;
                }
                else if (x == 0 && y != 0) {
                    ED[x][y] = y;
                }
                else {
                    int temp1 = ED[x - 1][y] + 1;
                    int temp2 = ED[x][y - 1] + 1;
                    int temp3 = ED[x - 1][y - 1];
                    if (tmp1[x - 1] != tmp2[y - 1]) {
                        temp3 += 2;
                    }
                    ED[x][y] = Math.min(temp1, Math.min(temp2, temp3));
                }
            }
        }

        return ED[tmp1.length][tmp2.length] <= 1;
    }
}
