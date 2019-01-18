package sort;

import utils.PrintHelper;

/**
 * 桶排序<br/>
 * 复杂度取决于待排序的内容的最大值和最小值的差别。
 *
 * @author zhangshibo
 */
public class BucketSort {

    public static void bucketSort(int[] nums, int max) {
        int[] buckets = new int[max + 1];
        for (int num : nums) {
            buckets[num]++;
        }
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            int cur = buckets[i];
            while (cur > 0) {
                nums[j++] = i;
                cur--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        bucketSort(nums, 10);
        PrintHelper.printArray(nums);
    }
}
