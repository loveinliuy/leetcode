package h0.t4;

/**
 * description:
 *
 * @author zhangshibo  [2018/1/12].
 */
public class Pow {

    public double myPow(double x, int n) {
        long mN = n;
        if (n < 0) {
            x = 1 / x;
            mN = -mN;
        }
        double ans = 1;
        double cur = x;
        for (long i = mN; i > 0; i = i / 2) {
            if ((i % 2) == 1) {
                ans = ans * cur;
            }
            cur = cur * cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0000, 10));
    }
}
