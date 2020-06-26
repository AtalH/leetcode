/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = grid[i].length-1; j >= 0; j--) {
                if(i < grid.length-1 && j < grid[i].length-1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                } else if (i == grid.length-1 && j < grid[i].length-1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if(i < grid.length-1 && j == grid[i].length-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

