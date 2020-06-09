import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // special case
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] status = new boolean[nums.length];

        dfs(nums, result, path, status);

        return result;
    }

    // back track
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] status) {
        // 1. terminator
        if (path.size() == nums.length) {
            // *make a copy
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 2. current level
            if (status[i]) continue;
            status[i] = true;
            path.add(nums[i]);

            // 3. drill down
            dfs(nums, result, path, status);

            // 4. restore status
            status[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

