package h3.t0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshibo
 */
public class RangeSumQueryImmutable {

    private static class NumArray {

        private final int[] sum;

        public NumArray(int[] nums) {
            this.sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (i > j) {
                throw new IllegalArgumentException("i>j");
            }
            return sum[j + 1] - sum[i];
        }
    }

}
