package h1.t6;

import org.junit.Assert;
import org.junit.Test;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/26].
 */
public class AddBinary {

    @Test
    public void test() {
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("11010", addBinary("11000", "10"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
