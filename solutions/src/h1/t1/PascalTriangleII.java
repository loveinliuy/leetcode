package h1.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangshibo
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 1; i <= rowIndex; i++) {
            int cur = (int) ((long) result.get(i - 1) * (rowIndex - i + 1) / i);
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(new PascalTriangleII().getRow(i));
        }
    }
}
