package h3.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class ReverseString {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";

        String result = new ReverseString().reverseString(input);

        System.out.println(result);
    }
}
