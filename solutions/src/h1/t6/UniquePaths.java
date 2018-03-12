package h1.t6;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class UniquePaths {

    /**
     * 思路：
     * 问题可以抽象成 f(m, n) = f(m-1, n) + f(m, n-1)
     * 结束条件为m或者n有一个为1。
     */
    // 递归方式 超时
//    public int uniquePaths(int m, int n) {
//        if(m == 0 || n == 0){
//            return 0;
//        }
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(23, 12));
    }
}
