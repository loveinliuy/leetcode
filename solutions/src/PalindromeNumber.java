/**
 * description:
 *
 * @author zhangshibo  [2017/6/8].
 */
public class PalindromeNumber {

//    public boolean isPalindrome(int x) {
//        String s = String.valueOf(x);
//
//        int start = 0;
//        int end = s.length() - 1;
//
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        int input = 12321;

        System.out.println(new PalindromeNumber().isPalindrome(input));
    }
}
