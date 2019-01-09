package h0.t1;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class LetterCombinationsOfAPhoneNumber {

//    // my solution
//    private static final char[][] DIGITS = {
//            {' '},
//            {},
//            {'a', 'b', 'c'},
//            {'d', 'e', 'f'},
//            {'g', 'h', 'i'},
//            {'j', 'k', 'l'},
//            {'m', 'n', 'o'},
//            {'p', 'q', 'r', 's'},
//            {'t', 'u', 'v'},
//            {'w', 'x', 'y', 'z'},
//    };
//
//    public List<String> letterCombinations(String digits) {
//        if (digits.length() == 0) {
//            return new ArrayList<>();
//        }
//        List<String> temp = new ArrayList<>();
//        for (int i = 0; i < DIGITS[digits.charAt(0) - '0'].length; i++) {
//            temp.add("" + DIGITS[digits.charAt(0) - '0'][i]);
//        }
//        if (digits.length() == 1) {
//            return temp;
//        }
//        List<String> result = new ArrayList<>();
//        for (int i = 1; i < digits.length(); i++) {
//            char c = digits.charAt(i);
//            if (c < '0' || c > '9') {
//                return result;
//            } else {
//                int digit = c - '0';
//                char[] curArr = DIGITS[digit];
//                for (int j = 0; j < curArr.length; j++) {
//                    for (int k = 0; k < temp.size(); k++) {
//                        result.add(temp.get(k) + curArr[j]);
//                    }
//                }
//                if (i + 1 < digits.length()) {
//                    temp = result;
//                    result = new ArrayList<>();
//                }
//            }
//        }
//        return result;
//    }

//    // better solution
//    public List<String> letterCombinations(String digits) {
//        String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        List<String> result = new ArrayList<>();
//        StringBuilder builder = new StringBuilder();
//        int depth = 0;
//        if (digits == null || digits.length() == 0) return result;
//        dfs(digits, 0, map, builder, result);
//
//        return result;
//    }
//
//    //dfs with backtracking
//    private void dfs(String digits, int depth, String[] map, StringBuilder builder, List<String> result) {
//        if (depth == digits.length()) {
//            result.add(builder.toString());
//            return;
//        }
//
//        for (int i = 0; i < map[digits.charAt(depth) - '0'].length(); i++) {
//            builder.append(map[digits.charAt(depth) - '0'].charAt(i));
//            dfs(digits, depth + 1, map, builder, result);
//            builder.deleteCharAt(builder.length() - 1);
//        }
//    }

    // i think this is the best solution
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "23";
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations(input));
    }
}
