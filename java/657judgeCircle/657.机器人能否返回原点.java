/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return true;
        }
        char[] ms = moves.toCharArray();
        int rCount = 0, lCount = 0, uCount = 0, dCount = 0;
        for (char m : ms) {
           if (m == 'R') {
            rCount += 1;
           } else if (m == 'L') {
            lCount += 1;
           } else if (m == 'U') {
            uCount += 1;
           } else if (m == 'D') {
            dCount += 1;
           }
        }
        return rCount-lCount == 0 && uCount-dCount == 0;
    }
}
// @lc code=end

