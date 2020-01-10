package crackingleetcode;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * @author 58212
 * @date 2020-01-11 1:16
 */
public class WordSearch_79 {

    int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int boardX;
    int boardY;

    public boolean exist(char[][] board, String word) {

        boardX = board.length;
        boardY = board[0].length;
        visited = new boolean[boardX][boardY];
        for (int i = 0; i < boardX; i++) {
            for (int j = 0; j < boardY; j++) {
                if (searchChar(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchChar(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[x][y];
        }
        if (word.charAt(index) == board[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + offset[i][0];
                int newY = y + offset[i][1];
                if (validPos(newX, newY) && !visited[newX][newY]) {
                    if (searchChar(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean validPos(int x, int y) {
        return x >= 0 && y >= 0 && x < boardX && y < boardY;
    }
}
