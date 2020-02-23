package ninechapters.dplesson1;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the
 * row below.
 *
 * @author Haoming Chen
 * Created on 2020/2/24
 */
public class Triangle_109 {
    //DFS Time limit exceeded
    int max = Integer.MAX_VALUE;

    public int minimumTotal(int[][] triangle) {
        if (triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }
        traverse(triangle, 0, 0, 0, triangle[0].length - 1);
        return max;
    }

    private void traverse(int[][] triangle, int level, int sum, int start, int end) {
        if (level >= triangle.length) {
            max = Math.min(sum, max);
            return;
        }
        for (int i = start; i <= end; i++) {
            int curr = sum + triangle[level][i];
            traverse(triangle, level + 1, curr, i, i + 1);
        }
    }

}
