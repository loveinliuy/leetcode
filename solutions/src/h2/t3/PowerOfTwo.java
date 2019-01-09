package h2.t3;

/**
 * @author zhangshibo
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int cur = n;
        while ((cur % 2) == 0) {
            cur = cur / 2;
        }
        return cur == 1;
    }

    public boolean isPowerOfTwoB(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwoB(8));
    }
}
