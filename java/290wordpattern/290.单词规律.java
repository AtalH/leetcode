/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() !=  words.length) {
            return false;
        }
        Map<Object, Integer> matchMap = new HashMap<>();
        // 此处使用 Integer 而不是 int，是因为如果用 int，放入 Map 会有自动装箱成 Integer 的行为。
        // 由于整型的缓存机制，当整型数字不在 -128~127 范围（默认范围）内时，Map.put() 返回的 Integer 对象使用 != 比较会 false
        for (Integer i = 0; i < words.length; i++) {
            Integer preIndexOfPatternChar = matchMap.put(pattern.charAt(i), i);
            Integer preIndexOfWord = matchMap.put(words[i], i);
            if (preIndexOfPatternChar != preIndexOfWord) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

