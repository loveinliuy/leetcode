package h1.t3;

/**
 * @author zhangshibo
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] given = {2, 2, 1};
        System.out.println(new SingleNumber().singleNumber(given));
    }
}
