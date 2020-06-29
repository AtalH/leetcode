/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        if (matrix[0][0] == target || matrix[m - 1][n - 1] == target) {
            return true;
        } else if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        int start = 0;
        int end = n * m -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

