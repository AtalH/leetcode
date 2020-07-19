/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] countArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = countArray[c-'a'];
            count++;
            countArray[c-'a'] = count;
        }
        for (int i = 0; i < s.length(); i++) {
            if(countArray[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

