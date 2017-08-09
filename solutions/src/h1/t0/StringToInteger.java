package h1.t0;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/8].
 */
public class StringToInteger {

    public int myAtoi(String str) {
        int i = 0, result = 0;
        boolean negative = false;
        if (str.length() == 0) {
            return 0;
        }
        while (str.charAt(i) == ' ' && i < str.length()) {
            i++;
        }

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            negative = str.charAt(i) == '-';
            i++;
        }

        while (i < str.length()) {
            int d = str.charAt(i) - '0';
            if (d < 0 || d > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < d) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + d;
            i++;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        String input = "-123321";

        int result = new StringToInteger().myAtoi(input);

        System.out.println(result);
//        System.out.println(Integer.valueOf("-0012a42"));
    }
}
