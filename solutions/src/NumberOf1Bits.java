/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new NumberOf1Bits().hammingWeight(Integer.MIN_VALUE);
        System.out.println(result);
    }
}
