package lintcode;

/**
 * @author Haoming Chen
 * @date 2020-02-03 15:28
 */
public class 牛郎织女 {

    public static void main(String[] args) {
        String[] maze = {"...*.",".T*S.",".*...","..**.","..*.*"};
//        String[] maze = {"S..*","*.**","...T"};
//        String[] maze2 = {"S..*","***.","...T"};
        System.out.println(牛郎织女.findHer(maze));
    }

    static int[][] offset = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static boolean res = false;

    public static boolean findHer(String[] maze) {
        visited = new boolean[maze.length][maze[0].length()];
        int[] sPos = new int[2];
        int[] tPos = new int[2];
        int valid = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].charAt(j) == 'S') {
                    sPos[0] = i;
                    sPos[1] = j;
                    valid++;
                }
                if (maze[i].charAt(j) == 'T') {
                    tPos[0] = i;
                    tPos[1] = j;
                    valid++;
                }
            }
        }
        if(valid != 2){
            return res;
        }
        tracer(tPos, maze, sPos[0], sPos[1]);
        return res;
    }

    private static void tracer(int[] target, String[] maze, int x, int y) {
        if(target[0] == x && target[1] == y){
            res = true;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < offset.length; i++) {
            int newX = x + offset[i][0];
            int newY = y + offset[i][1];
            if(isValid(newX, newY, maze) && !visited[newX][newY]) {
                tracer(target, maze, newX, newY);
            }
        }
        visited[x][y] = false;
    }

    private static boolean isValid(int x, int y, String[] maze) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[x].length() && maze[x].charAt(y) != '*';
    }

}
