package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋遍历二维数组
 *
 * @author 58212
 * @date 2019-12-28 22:50
 */
public class SpiralMatrix_54 {

    public static void main(String[] args) {
        int[][] twoDArr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //the output should be 1 2 3 6 9 8 7 4 5
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //make sure the row we travel exists
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            down--;
            //make sure the column we travel exists
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }

}
