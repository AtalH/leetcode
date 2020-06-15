import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        // can not go back to begin
        wordSet.remove(beginWord);
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordSet) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                chars[i] = '*';
                String key = String.valueOf(chars);
                List<String> words = wordMap.computeIfAbsent(key, k -> new ArrayList<>());
                words.add(word);
                chars[i] = temp;
            }
        }
        // doubleEndBfs
        Set<String> visitedSmaller = new HashSet<>();
        Set<String> visitedBigger = new HashSet<>();
        visitedSmaller.add(beginWord);
        visitedBigger.add(endWord);
        Queue<String> qSmaller = new LinkedList<>();
        Queue<String> qBigger = new LinkedList<>();
        qSmaller.offer(beginWord);
        qBigger.offer(endWord);
        int result = 1;
        while (!qSmaller.isEmpty() && !qBigger.isEmpty()) {
            if (qSmaller.size() > qBigger.size()) {
                Set<String> visitedTemp = visitedSmaller;
                visitedSmaller = visitedBigger;
                visitedBigger = visitedTemp;
                Queue<String> qTemp = qSmaller;
                qSmaller = qBigger;
                qBigger = qTemp;

            }
            Queue<String> qNext = new LinkedList<>();
            while (!qSmaller.isEmpty()) {
                String word = qSmaller.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char temp = chars[j];
                    chars[j] = '*';
                    String key = String.valueOf(chars);
                    chars[j] = temp;
                    List<String> words = wordMap.getOrDefault(key, new ArrayList<>());
                    for (String s : words) {
                        if (visitedBigger.contains(s)) {
                            return result + 1;
                        }
                        if (!visitedSmaller.contains(s)) {
                            visitedSmaller.add(s);
                            qNext.add(s);
                        }
                    }
                }
            }
            qSmaller.addAll(qNext);
            result++;
        }
        return 0;
    }
}
// @lc code=end

