/*
* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.
* https://leetcode.com/problems/search-a-2d-matrix/
* */

public class SearchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0, hi = n*m -1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(matrix[mid/m][mid%m] == target){
                return true;
            }else if(matrix[mid/m][mid%m] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}
