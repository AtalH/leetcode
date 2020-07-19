import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = countMap.get(c);
            if(count == null) {
                count = 1;
            }else{
                count++;
            }
            countMap.put(c, count);
        }
        for (int i = 0; i < s.length(); i++) {
            if(countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

