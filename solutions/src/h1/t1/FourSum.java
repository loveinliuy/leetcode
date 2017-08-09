package h1.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/12].
 */
public class FourSum {

    // win over 100% answer by rikimberley

    // split the question to three-sum circumstance.

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i > 0 && cur == nums[i - 1]) {
                continue;
            }
            if (cur + 3 * max < target) {
                continue;
            }
            if (4 * cur > target) {
                break;
            }
            if (4 * cur == target) {
                if (i + 3 < len && nums[i + 3] == cur) {
                    result.add(Arrays.asList(cur, cur, cur, cur));
                }
                break;
            }

            threeSumForFourSum(nums, target - cur, i + 1, len - 1, result, cur);
        }
        return result;
    }

    public void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> result, int min) {
        if (low + 1 >= high) {
            return;
        }
        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) {
            return;
        }
        for (int i = low; i < high - 1; i++) {
            int cur = nums[i];
            if (i > low && cur == nums[i - 1]) {
                continue;
            }
            if (cur + 2 * max < target) {
                continue;
            }
            if (3 * cur > target) {
                break;
            }
            if (3 * cur == target) {
                if (i + 1 < high && nums[i + 2] == cur) {
                    result.add(Arrays.asList(min, cur, cur, cur));
                }
                break;
            }

            twoSumForFourSum(nums, target - cur, i + 1, high, result, cur, min);
        }
    }

    public void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> result, int secondMin, int min) {
        if (low >= high) {
            return;
        }
        if (2 * nums[low] > target || 2 * nums[high] < target) {
            return;
        }
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                result.add(Arrays.asList(min, secondMin, nums[low], nums[high]));
                low++;
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
                high--;
                while (low < high && nums[high] == nums[high + 1]) {
                    high--;
                }
            }
            if (sum < target) {
                low++;
            }
            if (sum > target) {
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        int target = -9;

        List<List<Integer>> result = new FourSum().fourSum(input, target);

        System.out.println(result);
    }
}
