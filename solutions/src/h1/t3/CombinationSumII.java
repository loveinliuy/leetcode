package h1.t3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/25].
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                backtrace(result, temp, nums, remain - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = new CombinationSumII().combinationSum2(candidates, target);

        System.out.println(result);
    }
}
