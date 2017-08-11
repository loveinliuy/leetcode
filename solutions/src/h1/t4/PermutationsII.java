package h1.t4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/8/10].
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrace(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);

        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                backtrace(result, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(new PermutationsII().permuteUnique(nums));
    }
}
