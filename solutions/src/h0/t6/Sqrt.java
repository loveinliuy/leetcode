package h0.t6;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/26].
 */
public class Sqrt {


    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = Math.min(x, 46340);
        int mid = -1;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            int possible = mid * mid;
            if (possible > x) {
                high = mid - 1;
            } else if (possible < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        if (mid * mid > x) {
            return mid - 1;
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
//        System.out.println(s.mySqrt(2147395599));
        System.out.println(s.mySqrt(2147483647));
    }
}
