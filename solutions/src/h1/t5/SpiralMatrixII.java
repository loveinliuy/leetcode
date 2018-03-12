package h1.t5;

import utils.PrintHelper;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int num = 0;
        int r1 = 0;
        int r2 = n - 1;
        int c1 = 0;
        int c2 = n - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = r1; i < r2; i++) {
                result[c1][i] = ++num;
            }
            for (int i = c1; i < c2; i++) {
                result[i][r2] = ++num;
            }
            if (r1 < r2 && c1 < c2) {
                for (int i = r2; i > r1; i--) {
                    result[c2][i] = ++num;
                }
                for (int i = c2; i > c1; i--) {
                    result[i][r1] = ++num;
                }
            }
            if (r1 == r2 && c1 == c2) {
                result[r1][c1] = ++num;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new SpiralMatrixII().generateMatrix(4);
        PrintHelper.printMatrix(arr);
    }
}
