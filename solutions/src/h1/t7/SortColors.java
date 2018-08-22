package h1.t7;

import utils.PrintHelper;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/31].
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(i <= right){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                i++;
            } else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int src, int dest) {
        int tmp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = tmp;
    }
//    public void sortColors(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        int c0 = 0;
//        int c1 = 0;
//        int c2 = 0;
//        for (int i : nums) {
//            if (i == 0) {
//                c0++;
//            } else if (i == 1) {
//                c1++;
//            } else {
//                c2++;
//            }
//        }
//        for (int i = 0; i < c0; i++) {
//            nums[i] = 0;
//        }
//        for (int i = c0; i < c1 + c0; i++) {
//            nums[i] = 1;
//        }
//        for (int i = c0 + c1; i < c0 + c1 + c2; i++) {
//            nums[i] = 2;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        PrintHelper.printArray(nums);
    }
}
