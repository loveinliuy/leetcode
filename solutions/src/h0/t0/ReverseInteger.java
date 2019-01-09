package h0.t0;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        String s = String.valueOf(x);
        int end = isNegative ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for (int i = s.length() - 1; i >= end; i--) {
            sb.append(str[i]);
        }

        long r = Long.valueOf(sb.toString());
        if (r > Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) {
            return (int) (-1 * r);
        }

        return (int) r;
    }

    public static void main(String[] args) {
        int input = 123;

        int result = new ReverseInteger().reverse(input);

        System.out.println(result);
    }
}
