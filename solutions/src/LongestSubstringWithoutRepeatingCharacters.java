import java.util.*;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        char[] sArr = s.toCharArray();
        int lp = 0;
        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if (map.containsKey(c)) {
                lp = Math.max(lp, map.get(c) + 1);
            }
            map.put(c, i);
            result = Math.max(result, i - lp + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();

        String s1 = "abcabcbb";
        System.out.println(o.lengthOfLongestSubstring(s1));

        String s2 = "aab";
        System.out.println(o.lengthOfLongestSubstring(s2));

        String s3 = "dvdf";
        System.out.println(o.lengthOfLongestSubstring(s3));
    }
}
