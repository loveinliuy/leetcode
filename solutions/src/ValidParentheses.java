import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/13].
 */
public class ValidParentheses {

    private static final Map<Character, Character> C_MAP = new HashMap<>();

    static {
        C_MAP.put(')', '(');
        C_MAP.put(']', '[');
        C_MAP.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (C_MAP.containsKey(c)) {
                if (stack.isEmpty() || !C_MAP.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String input = "]";

        System.out.println(new ValidParentheses().isValid(input));
    }
}
