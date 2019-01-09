package h2.t3;

import utils.PrintHelper;

/**
 * @author zhangshibo
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        result[0] = left;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            result[i] = left;
        }
        int right = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            right *= nums[j + 1];
            result[j] *= right;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 0, -2};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        PrintHelper.printArray(result);
    }
}
