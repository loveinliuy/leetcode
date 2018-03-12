package h1.t6;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class UniquePathsII {

    /**
     * 思路：
     * 新建矩阵，对于原有矩阵为0的情况，填充dp，有障碍物时填充0
     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid == null||obstacleGrid.length == 0 ) return 0;
//        if(obstacleGrid[0].length == 0) return 1;
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//
//        int[][] dp = new int[m+1][n+1];
//        dp[0][1] = 1;
//
//        for(int i = 1; i <= m; i++) {
//            for(int j = 1; j <= n; j++) {
//                if(obstacleGrid[i-1][j-1] == 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                else dp[i][j] = 0;
//            }
//        }
//
//        return dp[m][n];
//    }

    /**
     * 思路：
     * 填充原有矩阵，用负数表示可以行走的距离，遇到1进行单独处理
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = -1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    if (obstacleGrid[i - 1][j] == 1) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] == 1) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        int result = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        if (result == 1) {
            return 0;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 0, 0, 1},
//                {0, 1, 1, 1},
//                {0, 0, 1, 0}
//        };
        int[][] arr = {{0, 0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(arr));
    }
}
