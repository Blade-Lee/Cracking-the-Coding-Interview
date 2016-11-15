package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] test = {{1,2,3},{4,0,6},{7,8,9}};

        zeroMatrix(test);

        for(int i = 0; i < test.length; i++){
            for (int j = 0; j < test[0].length; ++j) {
                System.out.format("%d ", test[i][j]);
            }
            System.out.println();
        }
    }

    public static void zeroMatrix(int[][] matrix) {
        int row_size = matrix.length;
        int column_size = matrix[0].length;

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < column_size; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < column_size; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
