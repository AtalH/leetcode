import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 排序后的 nums 遇到大于 0 的元素就没有必要继续了
            if (nums[i] > 0) {
                return result;
            }
            // 重复的元素 (i - 1 >= 0)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过重复项
                    while(l < r && nums[l+1] == nums[l]) l++;
                    while (l < r && nums[r-1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (temp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

