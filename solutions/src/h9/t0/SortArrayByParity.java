package h9.t0;

import utils.PrintHelper;

/**
 * @author zhangshibo
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                if (A[j] % 2 == 1) {
                    j--;
                }
                i++;
            } else {
                if (A[j] % 2 == 1) {
                    j--;
                } else {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    i++;
                    j--;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        PrintHelper.printArray(new SortArrayByParity().sortArrayByParity(new int[]{3, 1, 2, 4, 5}));
    }
}
