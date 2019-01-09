package h5.t1;

/**
 * @author zhangshibo
 */
public class FibonacciNumber {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args){
        System.out.println(new FibonacciNumber().fib(4));
    }
}
