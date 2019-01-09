package h0.t2;

import java.util.*;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/14].
 */
public class GenerateParentheses {

    // iterative solution
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");

        // use a list to save the status of how many ( or )
        LinkedList<Integer[]> nums = new LinkedList<>();
        nums.add(new Integer[]{0, 0});

        for (int i = 0; i < n * 2; i++) {
            while (result.peek().length() == i) {
                String s = result.remove();
                Integer[] num = nums.remove();
                if (num[0] < n) {
                    result.add(s + "(");
                    nums.add(new Integer[]{num[0] + 1, num[1]});
                }

                if (num[1] < num[0]) {
                    result.add(s + ")");
                    nums.add(new Integer[]{num[0], num[1] + 1});
                }
            }
        }

        return result;
    }

    // recursive solution
//    public List<String> generateParenthesis(int n) {
//        LinkedList<String> result = new LinkedList<>();
//        backtrack(result, "", 0, 0, n);
//        return result;
//    }
//
//    public void backtrack(List<String> list, String sb, int open, int close, int max) {
//        if (sb.length() == max * 2) {
//            list.add(sb);
//            return;
//        }
//
//        if (open < max) {
//            backtrack(list, sb + "(", open + 1, close, max);
//        }
//        if (close < open) {
//            backtrack(list, sb + ")", open, close + 1, max);
//        }
//    }

    public static void main(String[] args) {
        int input = 3;

        System.out.println(new GenerateParentheses().generateParenthesis(input));
    }
}
