package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] temp = {6, 4,9,3,6,6};

        quicksort(temp, 0, temp.length - 1);

        for (int k:temp) {
            System.out.format("%d ", k);
        }
        System.out.println();
    }


    public static void quicksort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = nums[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < mid) {
                i++;
            }
            while (nums[j] > mid) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        quicksort(nums, start, j);
        quicksort(nums, i, end);
    }

}