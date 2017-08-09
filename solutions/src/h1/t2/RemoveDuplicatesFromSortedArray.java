package h1.t2;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/20].
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[result - 1]) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
