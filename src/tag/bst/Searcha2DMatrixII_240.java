package tag.bst;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * @author 58212
 * @date 2019-11-14 0:14
 */
public class Searcha2DMatrixII_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while(col > -1 || row < matrix.length){
            if(matrix[row][col] == target){
                return true;
            }
            if(col == 0 && matrix[row][0] > target){
                return false;
            }
            if(row == matrix.length - 1 && matrix[matrix.length - 1][col] < target){
                return false;
            }
            if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

}
