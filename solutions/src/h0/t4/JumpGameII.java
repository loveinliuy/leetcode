package h0.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/8/8].
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int level = 0, currentMax = 0, i = 0, nextMax = 0;

        while (currentMax - i + 1 > 0) {
            level++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return level;
                }
            }
            currentMax = nextMax;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(new JumpGameII().jump(nums));
    }


}
