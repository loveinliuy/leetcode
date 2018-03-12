package h1.t5;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class PermutationSecquence {

    /**
     * 思路：
     * 根据公式计算出第k次变换，每一位的值，最后形成字符串。
     *
     * k=k-(上一个的下标）*(剩余内容数量）!
     */
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSecquence().getPermutation(3, 3));
    }
}
