package h1.t7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/27].
 */
public class SimplifyPath {

    private Stack<String> stack = new Stack<>();
    private StringBuilder sb = new StringBuilder(5);

    private void flush(){
        String cur = sb.toString();
        if(!cur.isEmpty()){
            if (".".equals(cur)) {
                sb = new StringBuilder(10);
            } else if ("..".equals(cur)) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                sb = new StringBuilder(10);
            } else {
                sb = new StringBuilder(10);
                stack.push(cur);
            }
        }

    }

    public String simplifyPath(String path) {
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
                i--;
                flush();
                continue;
            }
            sb.append(c);
        }
        flush();
        List<String> result = new ArrayList<>(stack);
        if (result.isEmpty()) {
            return "/";
        }
        StringBuilder s = new StringBuilder(result.size() * 10);
        for (String res : result) {
            s.append("/").append(res);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String p = "/.a";
        System.out.println(new SimplifyPath().simplifyPath(p));
    }
}
