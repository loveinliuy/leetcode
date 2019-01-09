package h1.t2;

/**
 * @author zhangshibo
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            while (!needConsider(c[i]) && i < j) {
                i++;
            }
            while (!needConsider(c[j]) && i < j) {
                j--;
            }
            if (Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean needConsider(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}
