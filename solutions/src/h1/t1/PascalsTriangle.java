package h1.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangshibo
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 1; i <= numRows; i++) {
            generate(result, i);
        }
        return result;
    }

    private void generate(List<List<Integer>> list, int index) {
        if (index == 1) {
            list.add(Collections.singletonList(1));
            return;
        }
        if (index == 2){
            list.add(Arrays.asList(1, 1));
            return;
        }
        List<Integer> last = list.get(index - 2);
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 0; i < last.size() - 1; i++) {
            cur.add(last.get(i) + last.get(i + 1));
        }
        cur.add(1);
        list.add(cur);
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }

}
