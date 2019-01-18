package h2.t0;

/**
 * @author zhangshibo
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int x = n;
        int sum = 0;
        while (x > 0) {
            sum += Math.pow(x % 10, 2);
            x = x / 10;
        }
        sum += Math.pow(x % 10, 2);
        if (sum == 1) {
            return true;
        } else {
            if (sum == 4) {
                return false;
            } else {
                return isHappy(sum);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(16));
    }

}
