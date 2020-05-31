import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s==null ? 0 : s.length();
        int tlen = t==null ? 0 : t.length();

        if (slen == 0 && tlen == 0) {
            return true;
        } else if (slen != tlen) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tAarray = t.toCharArray();
        for (int i = 0; i < slen; i++) {
            Integer count = countMap.get(sArray[i]);
            if (count == null) {
                count = 0;
            }
            countMap.put(sArray[i], ++count);

            count = countMap.get(tAarray[i]);
            if (count == null) {
                count = 0;
            }
            countMap.put(tAarray[i], --count);
        }
        for (int i : countMap.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

