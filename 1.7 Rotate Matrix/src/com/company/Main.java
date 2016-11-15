package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {{1,2,3, 4}, {5,6,7,8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        for (int[] row: matrix) {
            for (int k: row) {
                System.out.format("%d ", k);
            }
            System.out.println();
        }

        System.out.println();

        int[][] result = rotate(matrix);

        for (int[] row: result) {
            for (int k: row) {
                System.out.format("%d ", k);
            }
            System.out.println();
        }
    }

    static int[][] rotate(int[][] matrix) {
        int N = matrix.length;

        for (int i = N; i > 0; i-=2) {
            int start = (N - i) / 2;
            int end = N - start - 1;
            if (start >= end) break;

            for (int j = 0; j <= end - start - 1; ++j) {
                int T = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = T;
            }
        }

        return matrix;
    }
}
