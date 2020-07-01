/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    islandCount++;
                    destroyIsland(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void destroyIsland(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if(i+1 < grid.length) {
            destroyIsland(grid, i+1, j);
        }
        if(i-1 >= 0) {
            destroyIsland(grid, i-1, j);
        }
        if(j+1 < grid[i].length) {
            destroyIsland(grid, i, j+1);
        }
        if(j-1 >= 0) {
            destroyIsland(grid, i, j-1);
        }
    }
}
// @lc code=end

