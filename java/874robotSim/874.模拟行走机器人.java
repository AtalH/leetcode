import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0, y = 0;
        int result = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                direction = (direction + 1) % 4;
            } else if (cmd == -2) {
                direction = (direction + 3) % 4;
            } else if (cmd > 0) {
                for (int i = 1; i <= cmd; i++) {
                    int xNext = x + directions[direction][0];
                    int yNext = y + directions[direction][1];
                    if (obstacleSet.contains(xNext + "," + yNext)) {
                        break;
                    } else {
                        x = xNext;
                        y = yNext;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

