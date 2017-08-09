package h1.t5;

/**
 * description:
 *
 * @author zhangshibo  [2017/8/8].
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int pos = s.length() - 1;
        int result = 0;

        while (pos >= 0 && s.charAt(pos) == ' ') {
            pos--;
        }

        while (pos >= 0 && s.charAt(pos) != ' ') {
            result++;
            pos--;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "    ";

        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
