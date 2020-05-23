/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int bullsCount = 0;
        int cowsCount = 0;
        /*
         * 在第 i 个循环，nums 的一个元素为 0 时，
         * 说明这个元素在 secret 和 guess 中出现的次数相同或者没有出现过
         */
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i)  - '0';
            int g = guess.charAt(i)  - '0';
            if (s == g) {
                bullsCount++;
            } else {
                if (nums[s] < 0) {
                    cowsCount++;
                }
                if (nums[g] > 0) {
                    cowsCount++;
                }
                nums[s]++;
                nums[g]--;
            }
        }
        return bullsCount + "A" + cowsCount + "B";
    }
}
// @lc code=end

