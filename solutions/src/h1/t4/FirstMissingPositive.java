package h1.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/26].
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};

        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
