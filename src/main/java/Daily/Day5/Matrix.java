package Daily.Day5;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        // matrix
        // rows and columns

        int[][]matrixJaggedArray = new int[4][];

        int[][] matrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = i * 3 + j + 1;
            }
        }
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.deepToString(matrix));

        for(int tempV : matrix[2]) {
            System.out.println(tempV);
        }

    }
}
