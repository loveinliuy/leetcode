package h1.t7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/31].
 */
public class Combinations {

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return result;
        }
        backtrace(1, n, k);
        return result;
    }

    private void backtrace(int i, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int j = i; j <= n; j++) {
                list.add(j);
                backtrace(j + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
