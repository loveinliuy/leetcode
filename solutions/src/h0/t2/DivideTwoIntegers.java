package h0.t2;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/20].
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int res = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }

        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = 1;

        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
