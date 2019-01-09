package h0.t4;

import utils.PrintHelper;

/**
 * Created by zhang on 2017/8/10.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int len = matrix.length;
        for (int i = len / 2 + len % 2 - 1; i >= 0; i--) {
            rotateCycle(matrix, i);
        }
    }

    private void rotateCycle(int[][] matrix, int circle) {
        int len = matrix.length;
        int pos1x = circle;
        int pos1y = circle;
        int pos2x = circle;
        int pos2y = len - 1 - circle;
        int pos3x = len - 1 - circle;
        int pos3y = len - 1 - circle;
        int pos4x = len - 1 - circle;
        int pos4y = circle;
        for (int i = 0; i <= len - 2 - (circle * 2); i++) {
            int temp = matrix[pos4x][pos4y];
            matrix[pos4x][pos4y] = matrix[pos3x][pos3y];
            matrix[pos3x][pos3y] = matrix[pos2x][pos2y];
            matrix[pos2x][pos2y] = matrix[pos1x][pos1y];
            matrix[pos1x][pos1y] = temp;
            pos1y += 1;
            pos2x += 1;
            pos3y -= 1;
            pos4x -= 1;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {};
//        int[][] matrix = {{1, 2}, {3, 4}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        PrintHelper.printMatrix(matrix);

        new RotateImage().rotate(matrix);

        PrintHelper.printMatrix(matrix);
    }
}
