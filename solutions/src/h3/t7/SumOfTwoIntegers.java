package h3.t7;

/**
 * @author zhangshibo
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args){
        System.out.println(new SumOfTwoIntegers().getSum(2, 3));
    }
}
