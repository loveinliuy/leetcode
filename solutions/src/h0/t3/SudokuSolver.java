package h0.t3;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/25].
 */
public class SudokuSolver {

    // 错误想法：
    // 查找出每个没有填充数字的位置可能填充的数字，然后找出只有1种情况的位置，填入指定数字
    // 但是会有很多想关联的情况，比较复杂，无法合适的处理
//    public void solveSudoku(char[][] board) {
//        Map<String, Set<Character>> map = new HashMap<>();
//        while (true) {
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    if (board[i][j] == '.') {
//                        map.put("" + i + j, getPossibleSolutionSet(board, i, j));
//                    }
//                }
//            }
//            if (map.size() == 0) {
//                break;
//            }
//            for (Map.Entry<String, Set<Character>> entry : map.entrySet()) {
//                if (entry.getValue().size() == 1) {
//                    int row = entry.getKey().charAt(0) - '0';
//                    int col = entry.getKey().charAt(1) - '0';
//                    board[row][col] = entry.getValue().iterator().next();
//                }
//            }
//            print(board);
//            map.clear();
//        }
//    }
//
//    private Set<Character> getPossibleSolutionSet(char[][] board, int i, int j) {
//        Set<Character> result = new HashSet<>();
//        for (char k = '1'; k <= '9'; k++) {
//            result.add(k);
//        }
//        for (int k = 0; k < 9; k++) {
//            result.remove(board[i][k]);
//        }
//        for (int k = 0; k < 9; k++) {
//            result.remove(board[k][j]);
//        }
//        int rowIndex = 3 * (i / 3);
//        int colIndex = 3 * (j / 3);
//        for (int k = rowIndex; k < rowIndex + 3; k++) {
//            for (int l = colIndex; l < colIndex + 3; l++) {
//                result.remove(board[k][l]);
//            }
//        }
//        return result;
//    }

    // 回溯法
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            int rowIndex = 3 * (row / 3) + i / 3;
            int colIndex = 3 * (col / 3) + i % 3;
            if (board[rowIndex][colIndex] != '.' && board[rowIndex][colIndex] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String source = "..9748...,7........,.2.1.9...,..7...24.,.64.1.59.,.98...3..,...8.3.2.,........6,...2759..";
//        String source = "53..7....,6..195...,.98....6.,8...6...3,4..8.3..1,7...2...6,.6....28.,...419..5,....8..79";
        char[][] board = convert(source);
        print(board);
        new SudokuSolver().solveSudoku(board);
        print(board);
    }

    private static char[][] convert(String source) {
        String src = source.replace("[", "");
        src = src.replace("]", "");
        src = src.replace("\"", "");
        String[] rows = src.split(",");
        char[][] board = new char[rows.length][];
        for (int i = 0; i < board.length; i++) {
            board[i] = rows[i].toCharArray();
        }
        return board;
    }

    private static void print(char[][] board) {
        System.out.println();
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
