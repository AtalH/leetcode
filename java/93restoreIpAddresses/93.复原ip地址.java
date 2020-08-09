/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        backTracking(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backTracking(String s, int index, int level, StringBuilder path, List<String> result) {
        if(level == 4 && index == s.length()) {
            path.setLength(path.length()-1);
            result.add(path.toString());
            path.append('.');
            return;
        }
        if(level > 4 || (s.length()-index) > (4-level)*3 || (s.length()-index) < (4-level)) {
            return;
        }
        int n = Math.min(s.length() - index, 3);
        for(int i = 1; i <= n; i++) {
            String netStr = s.substring(index, index+i);
            int net = -1;
            try {
                net = Integer.parseInt(netStr);
            } catch (NumberFormatException e) {
                return;
            }
            if(net <= 255) {
                path.append(netStr).append('.');
                backTracking(s, index+i, level+1, path, result);
                // restore status
                path.setLength(path.length() - i - 1);
            }
            if(net == 0) {
                break;
            }
        }
    }
}
// @lc code=end

