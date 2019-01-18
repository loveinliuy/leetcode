package h2.t6;

/**
 * @author zhangshibo
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (int) ((nums.length + 1) * (nums.length) / 2 - sum);
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }
}
