package h0.t1;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class LongestCommonPrefix {

    // my solution
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int minStrLen = Integer.MAX_VALUE;
//        for (String str : strs) {
//            minStrLen = Math.min(minStrLen, str.length());
//        }
//
//        for (int i = 0; i < minStrLen; i++) {
//            char cur = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                cur = strs[j].charAt(i);
//                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
//                    return sb.toString();
//                }
//            }
//            sb.append(cur);
//        }
//
//        return sb.toString();
//    }

    //better solution
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (String s : strs) {
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String in = "ABB,ABR";
        String[] input = in.split(",");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));
    }
}
