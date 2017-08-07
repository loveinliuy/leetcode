package hundred.h1.ten.t3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/25].
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrace(result, temp, nums, remain - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);

        System.out.println(result);
    }
}
