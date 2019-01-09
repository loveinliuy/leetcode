package h0.t6;

import org.junit.Assert;
import org.junit.Test;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/26].
 */
public class PlusOne {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{0}, plusOne(new int[]{0, 9}));
        Assert.assertArrayEquals(new int[]{1, 1}, plusOne(new int[]{1, 0}));
        Assert.assertArrayEquals(new int[]{1, 9}, plusOne(new int[]{1, 8}));
        Assert.assertArrayEquals(new int[]{2, 0}, plusOne(new int[]{1, 9}));
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
    }

    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            return new int[]{1};
        }
        int len = digits.length;
        boolean carry = false;
        digits[len - 1]++;
        if (digits[len - 1] < 10) {
            return digits;
        } else {
            carry = true;
            digits[len - 1] -= 10;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (!carry) {
                return digits;
            } else {
                digits[i]++;
                if (digits[i] >= 10) {
                    carry = true;
                    digits[i] -= 10;
                } else {
                    carry = false;
                }
            }
        }
        if (carry) {
            int[] result = new int[len + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, len);
            return result;
        } else {
            return digits;
        }
    }
}
