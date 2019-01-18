package sort;

import utils.PrintHelper;

/**
 * 快速排序<br/>
 * 最好情况：时间复杂度为O(nlogn)，空间复杂度为O(logn)<br/>
 * 最坏情况：时间复杂度为O(n*n)，空间复杂度为O(n)<br/>
 *
 * @author zhangshibo
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int k = nums[left];
        while (i != j) {
            while (nums[j] >= k && i < j) {
                j--;
            }
            while (nums[i] <= k && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[i];
        nums[i] = k;
        quickSort(nums, left, i - 1);
        quickSort(nums, j + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(nums);
        PrintHelper.printArray(nums);
    }
}
