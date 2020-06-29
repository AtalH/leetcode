/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0
                || matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if(matrix[0][0] == target || matrix[n - 1][m - 1] == target) {
            return true;
        }
        int start = 0;
        int end = n * m -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int midPoint = matrix[mid / m][mid % m];
            if(midPoint == target) {
                return true;
            } else if(midPoint > target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

