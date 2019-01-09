package h0.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class RomanToInteger {

    private static Map<String, Integer> map1 = new HashMap<>();

    private static Map<String, Integer> map2 = new HashMap<>();

    static {
        map1.put("M", 1000);
        map1.put("D", 500);
        map1.put("C", 100);
        map1.put("L", 50);
        map1.put("X", 10);
        map1.put("V", 5);
        map1.put("I", 1);

        map2.put("CM", 900);
        map2.put("CD", 400);
        map2.put("XC", 90);
        map2.put("XL", 40);
        map2.put("IX", 9);
        map2.put("IV", 4);
    }

    public int romanToInt(String s) {
        int result = 0, index = 0;
        while (index < s.length()) {
            if (index + 2 <= s.length() && map2.containsKey(s.substring(index, index + 2))) {
                result += map2.get(s.substring(index, index + 2));
                index = index + 2;
            } else if (index + 1 <= s.length() && map1.containsKey(s.substring(index, index + 1))) {
                result += map1.get(s.substring(index, index + 1));
                index = index + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "MCMXCVI";

        System.out.println(new RomanToInteger().romanToInt(input));
    }
}
