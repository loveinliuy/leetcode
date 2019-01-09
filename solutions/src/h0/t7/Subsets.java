package h0.t7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2018/8/1].
 */
public class Subsets {

    public List<List<Integer>> result = new LinkedList<>();
    public List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtrace(nums, 0);
        return result;
    }

    private void backtrace(int[] nums, int i) {
        result.add(new ArrayList<>(list));
        if (i == nums.length) {
            return;
        } else {
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                backtrace(nums, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }
}
