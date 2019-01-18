package h2.t1;

/**
 * @author zhangshibo
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = Math.min(i + k, nums.length - 1);
            while (i < j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, k));
    }
}
