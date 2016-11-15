package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String temp = "_ 1                                    ";
        System.out.println(URLify(temp, 2));

    }

    public static String URLify(String str, int real_len) {
        // Assumption:
        // Only whitespace used, no tab
        char[] temp = str.toCharArray();

        int point = 0;

        int spacecount = 0;
        int charcount = 0;

        for (;charcount != real_len; ++point) {
            if (temp[point] != ' ') ++charcount;
            else ++spacecount;
        }

        //System.out.format("charcount:%d, spacecount:%d\n", charcount, spacecount);

        point = charcount + spacecount - 1;

        for (;point >= 0; --point) {
            //System.out.format("charcount:%d, spacecount:%d, point:%d\n", charcount, spacecount, point);
            if (temp[point] != ' ') {
                temp[charcount + spacecount * 3 - 1] = temp[point];
                --charcount;
            }
            else {
                temp[charcount + spacecount * 3 - 1 - 2] = '%';
                temp[charcount + spacecount * 3 - 1 - 1] = '2';
                temp[charcount + spacecount * 3 - 1] = '0';
                --spacecount;
            }
        }

        return new String(temp);

    }
}
