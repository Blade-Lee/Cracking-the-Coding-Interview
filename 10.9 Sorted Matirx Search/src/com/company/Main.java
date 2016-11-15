package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        int[][] new_matrix = {{2, 3, 5, 7}};
        int[][] next_matrix = {{2}, {3}, {5}, {7}};
        System.out.println(newBinSearch(next_matrix, 6, 0, 0, 3, 0));
    }

    static boolean simpleBinSearch(int[][] matrix, int x) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == x) {
                return true;
            }
            else if (matrix[row][column] < x) {
                ++row;
            }
            else {
                --column;
            }
        }

        return false;
    }

    static boolean newBinSearch(int[][] matrix, int x, int start_row, int start_column, int end_row, int end_column) {
        if (matrix.length == 0) {
            return false;
        }

        int mid_row = (start_row + end_row) / 2;
        int mid_column = (start_column + end_column) / 2;

        System.out.format("Searching: (%d, %d)\n", matrix[start_row][start_column], matrix[end_row][end_column]);
        System.out.format("Mid: %d\n", matrix[mid_row][mid_column]);

        int value = matrix[mid_row][mid_column];

        if (value == x) {
            return true;
        }

        if (start_row == end_row && start_column == end_column) {
            return false;
        }

        if (mid_row + 1 <= matrix.length - 1 && mid_column + 1 <= matrix[0].length - 1) {
            int next_value = matrix[mid_row + 1][mid_column + 1];
            if (value < x) {
                boolean up_right = newBinSearch(matrix, x, start_row, mid_column + 1, mid_row, end_column);
                boolean down_left = newBinSearch(matrix, x, mid_row + 1, start_column, end_row, mid_column);
                if (x < next_value) {
                    return up_right || down_left;
                }
                else {
                    boolean down_right = newBinSearch(matrix, x, mid_row + 1, mid_column + 1, end_row, end_column);
                    return up_right || down_left || down_right;
                }
            }
            else {
                return newBinSearch(matrix, x, start_row, start_column, mid_row, mid_column);
            }
        }
        else if (mid_row + 1 <= matrix.length - 1) {
            if (value < x) {
                return newBinSearch(matrix, x, mid_row + 1, mid_column, end_row, mid_column);
            }
            else {
                return newBinSearch(matrix, x, start_row, mid_column, mid_row, mid_column);
            }
        }
        else if (mid_column + 1 <= matrix[0].length - 1) {
            if (value < x) {
                return newBinSearch(matrix, x, mid_row, mid_column + 1, mid_row, end_column);
            }
            else {
                return newBinSearch(matrix, x, mid_row, start_column, mid_row, mid_column);
            }
        }
        return false;
    }
}
