package h0.t7;

import utils.PrintHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/30].
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }
        // change
        for (Integer i : iSet) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : jSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        PrintHelper.printMatrix(martix);
        new SetMatrixZeroes().setZeroes(martix);
        PrintHelper.printMatrix(martix);
    }
}
