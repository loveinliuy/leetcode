package sort;

import utils.PrintHelper;

/**
 * 冒泡排序<br/>
 * 时间复杂度O(n*n)，空间复杂度O(1)
 *
 * @author zhangshibo
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        bubbleSort(nums);
        PrintHelper.printArray(nums);
    }
}
