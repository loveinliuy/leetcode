/**
 * description:
 *
 * @author zhangshibo  [2017/6/8].
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String result = "";
        int resultLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - resultLen - 1, i)) {
                result = s.substring(i - resultLen - 1, i + 1);
                resultLen = resultLen + 2;
            } else if (isPalindrome(s, i - resultLen, i)) {
                result = s.substring(i - resultLen, i + 1);
                resultLen = resultLen + 1;
            }
        }
        return result;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) {
            return false;
        }
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestPalindromicSubstring().isPalindrome("abccba", 0, 5));
//        System.out.println(new LongestPalindromicSubstring().isPalindrome("abcba", 0, 4));
//        System.out.println(new LongestPalindromicSubstring().isPalindrome("abcb", 1, 2));

        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abccbaa"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("accba"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abcbaa"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abcaa"));
    }
}
