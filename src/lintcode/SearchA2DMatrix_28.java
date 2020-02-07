package lintcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * @author Haoming Chen
 * Created on 2020/2/7
 */
public class SearchA2DMatrix_28 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int q = matrix.length;
        int p = matrix[0].length;
        int start = 0;
        int end = p * q - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / p][mid % p] == target) {
                end = mid;
            } else if (matrix[mid / p][mid % p] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / p][start % p] == target) {
            return true;
        }
        if (matrix[end / p][end % p] == target) {
            return true;
        }
        return false;
    }

}
