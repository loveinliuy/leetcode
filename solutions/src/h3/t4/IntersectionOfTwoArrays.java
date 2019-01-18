package h3.t4;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author zhangshibo
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            result[i++] = re;
        }
        return result;
    }

    public int[] intersectionB(int[] nums1, int[] nums2){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] bucket = new boolean[max - min + 1];
        for (int num : nums1) {
            bucket[num - min] = true;
        }
        int index = 0;
        for (int num : nums2) {
            if (num < min || num > max) {
                continue;
            }
            if (bucket[num - min]) {
                nums2[index++] = num;
                bucket[num - min] = false;
            }
        }
        return Arrays.copyOf(nums2, index);
    }

    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = new IntersectionOfTwoArrays().intersectionB(nums1, nums2);
        PrintHelper.printArray(result);
    }
}
