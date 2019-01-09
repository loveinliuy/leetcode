package h0.t7;

/**
 * description:
 *
 * @author zhangshibo  [2018/8/1].
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (find(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '-';
            if (k == word.length() - 1) {
                return true;
            } else if (find(board, word, i + 1, j, k + 1) ||
                    find(board, word, i - 1, j, k + 1) ||
                    find(board, word, i, j + 1, k + 1) ||
                    find(board, word, i, j - 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }


    public static void main(String[] args) {
//        char[][] board = {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
//        String word = "AAAAAAAAAAAAAAAAA";
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(new WordSearch().exist(board, word));
    }
}
