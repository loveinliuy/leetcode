package h3.t3;

import utils.PrintHelper;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/26].
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 1; i < num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int num = 5;

        PrintHelper.printArray(new CountingBits().countBits(num));
    }
}
