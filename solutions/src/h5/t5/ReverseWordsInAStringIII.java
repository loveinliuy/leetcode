package h5.t5;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author zhangshibo
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder result = new StringBuilder(s.length());
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
                result.append(c);
            } else {
                stack.push(c);
            }
        }
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public String reverseWordsB(String s){
        return Arrays.stream(s.split(" ")).map(str -> new StringBuilder(str).reverse()).collect(Collectors.joining(" "));
    }


}
