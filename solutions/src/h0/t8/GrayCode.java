package h0.t8;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangshibo
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new GrayCode().grayCode(3));
    }
}
