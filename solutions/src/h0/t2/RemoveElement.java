package h0.t2;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/20].
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 3};
        int val = 2;

        System.out.println(new RemoveElement().removeElement(nums, val));
        for (int n : nums) {
            System.out.print(n + ", ");
        }
    }
}
