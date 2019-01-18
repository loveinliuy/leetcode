package h2.t7;

/**
 * @author zhangshibo
 */
public class FirstBadVersion {


    private boolean isBadVersion(int n) {
        return n > 3;
    }

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int n = new FirstBadVersion().firstBadVersion(Integer.MAX_VALUE);
        System.out.println(n);
    }
}
