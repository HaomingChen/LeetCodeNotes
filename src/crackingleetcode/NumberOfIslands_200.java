package crackingleetcode;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 *
 * @author 58212
 * @date 2020-01-11 23:03
 */
public class NumberOfIslands_200 {
    int count = 0;
    int[][] offset = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int boardX;
    int boardY;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        boardX = grid.length;
        boardY = grid[0].length;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < boardX; i++) {
            for (int j = 0; j < boardY; j++) {
                if (!visited[i][j] && findIslands(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findIslands(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return false;
        } else {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + offset[i][0];
                int newY = y + offset[i][1];
                if (validPos(newX, newY) && !visited[newX][newY]) {
                    findIslands(grid, newX, newY);
                }
            }
            return true;
        }
    }

    private boolean validPos(int x, int y) {
        return x >= 0 && y >= 0 && x < boardX && y < boardY;
    }
}
