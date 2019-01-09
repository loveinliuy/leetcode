package h0.t7;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/30].
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int line = searchLine(matrix, target);
        if (line == -1) {
            return false;
        }
        int col = searchColumn(matrix, target, line);
        return col != -1;
    }

    private int searchColumn(int[][] matrix, int target, int line) {
        int lowPos = 0;
        int highPos = matrix[line].length - 1;
        if (target == matrix[line][highPos]) {
            return highPos;
        }
        if (target == matrix[line][lowPos]) {
            return lowPos;
        }
        if (target > matrix[line][highPos] || target < matrix[line][lowPos]) {
            return -1;
        }
        while (highPos >= lowPos) {
            int midPos = (highPos - lowPos) / 2 + lowPos;
            int mid = matrix[line][midPos];
            if (target > mid) {
                lowPos = midPos;
            } else if (target < mid) {
                highPos = midPos;
            } else {
                return midPos;
            }
            if(highPos - lowPos == 1){
                return -1;
            }
        }
        return -1;
    }

    private int searchLine(int[][] matrix, int target) {
        // 判断所在行
        int lowPos = 0;
        int highPos = matrix.length - 1;
        if (target >= matrix[highPos][0]) {
            return highPos;
        }
        if (target <= matrix[lowPos][0]) {
            return lowPos;
        }
        while (highPos >= lowPos) {
            int midPos = (highPos - lowPos) / 2 + lowPos;
            int mid = matrix[midPos][0];
            if (target > mid) {
                lowPos = midPos;
            } else if (target < mid) {
                highPos = midPos;
            } else {
                return midPos;
            }
            if(highPos - lowPos == 1){
                return lowPos;
            }
        }
        return lowPos;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        int target = 3;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));
    }
}
