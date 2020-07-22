import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Set<String> fronSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        fronSet.add(beginWord);
        endSet.add(endWord);
        int result = 1;
        while(!fronSet.isEmpty() && !endSet.isEmpty()) {
            if(endSet.size() < fronSet.size()) {
                Set<String> temp = fronSet;
                fronSet = endSet;
                endSet = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String word : fronSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char t = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if(endSet.contains(newWord)) {
                            return result + 1;
                        } 
                        if(!visited.contains(newWord) && wordSet.contains(newWord)){
                            visited.add(newWord);
                            nextSet.add(newWord);
                        }
                    }
                    chars[i] = t;
                }
            }
            fronSet = nextSet;
            result++;
        }
        return 0;
    }
}
// @lc code=end

