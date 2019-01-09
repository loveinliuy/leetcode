package h1.t6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshibo
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElementMore(nums);
    }

    public int majorityElementNormal(int[] nums) {
        int count = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(count);
        for (int n : nums) {
            if (map.containsKey(n)) {
                Integer i = map.get(n);
                if (i + 1 > count) {
                    return n;
                } else {
                    map.put(n, i + 1);
                }
            } else {
                map.put(n, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    public int majorityElementMore(int[] nums) {
        // 摩尔投票法
        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i + 1];
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 4, 4, 4, 2, 2};
        int[] nums = {1};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
