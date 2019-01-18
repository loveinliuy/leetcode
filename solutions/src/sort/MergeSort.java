package sort;

import utils.PrintHelper;

/**
 * 稳定的排序算法，时间复杂度为O(nlogn)，需要使用O(n)的辅助空间来做归并
 *
 * @author zhangshibo
 */
public class MergeSort {

    public static void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }


    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        PrintHelper.printArray(nums);
        mergeSort(nums);
        PrintHelper.printArray(nums);
    }

}
