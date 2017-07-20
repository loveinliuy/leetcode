import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/20].
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<>(); // map for words
        for (String w : words) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) { // checkc if match
                String str = s.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else {
                    break; // not in words
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};

        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }
}
