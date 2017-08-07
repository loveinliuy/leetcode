package hundred.h1.ten.t3;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/25].
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = countAndSayInternal(s);
        }
        return s;
    }

    private String countAndSayInternal(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count).append(s.charAt(i));
            count = 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 2;

        System.out.println(new CountAndSay().countAndSay(n));
    }
}
