package h2.t1;

import java.util.Arrays;

/**
 * @author zhangshibo
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        // 使用快速排序，在排序过程中直接选择快速中断
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new KthLargestElementInArray().findKthLargest(nums, 2));
    }
}
