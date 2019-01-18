package h2.t9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshibo
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(pattern.length() / 2);
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = split[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s)) {
                    return false;
                }
            } else {
                if (map.containsValue(s)) {
                    return false;
                }
                map.put(c, s);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abbc";
        String s = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, s));
    }
}
