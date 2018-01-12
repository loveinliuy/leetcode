package h1.t4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author zhangshibo  [2018/1/12].
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        if (strs == null) {
            return new ArrayList<>();
        }
        for (String s : strs) {
            String sort = sort(s);
            if (result.containsKey(sort)) {
                result.get(sort).add(s);
            } else {
                List<String> list = new LinkedList<>();
                list.add(s);
                result.put(sort(s), list);
            }
        }
        return new ArrayList<>(result.values());
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        // quick sort by java
        Arrays.sort(arr);
        // bubble sort
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    char tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//            }
//        }
        return new String(arr);
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }


}
