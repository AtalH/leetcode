/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    // 注意前后空格和多空格连在一起的情况
    public int countSegments(String s) {
        boolean wordFlag = false;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ' && wordFlag) {
                wordFlag = false;
            } else if (c != ' ' && !wordFlag){
                wordFlag = true;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

