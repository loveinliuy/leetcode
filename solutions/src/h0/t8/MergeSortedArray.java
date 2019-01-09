package h0.t8;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zhangshibo
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curPos = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            int max;
            if (n1 > n2) {
                max = n1;
                i--;
            } else {
                max = n2;
                j--;
            }
            nums1[curPos--] = max;
        }
        while (i >= 0) {
            nums1[curPos--] = nums1[i];
            i--;
        }
        while (j >= 0) {
            nums1[curPos--] = nums2[j];
            j--;
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {0, 1};
//        int n = 2;
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        new MergeSortedArray().merge(nums1, m, nums2, n);

        System.out.println(Arrays.stream(nums1).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }
}
