package h1.t1;

import java.util.Arrays;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int cur = nums[i] + nums[j] + nums[k];
                if (cur > target) {
                    // we need remove the repeat first
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if(cur < target){
                    j++;
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                } else{
                    // it takes over 30ms run time until add this block
                    return cur;
                }

                if (Math.abs(cur - target) < Math.abs(closest - target)) {
                    closest = cur;
                }

            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] input = {-1, 1, 1, 0, 55};
        int target = 3;

        int result = new ThreeSumClosest().threeSumClosest(input, target);

        System.out.println(result);
    }
}
