import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    /**
     * 1、暴力法：两层循环，时间复杂度 k*n
     * 2、其中较小的数组放到 hashMap 内，key是值，value是出现次数。时间复杂度 k+n
     * 3、先将两个数组排序，利用双指针在一次循环内解决
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> num1Map = new HashMap<>();
        for (int n1 : nums1) {
            Integer count = num1Map.get(n1);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            num1Map.put(n1, count);
        }
        int[] result = nums1;
        int resultCount = 0;
        for (int n2 : nums2) {
            Integer count = num1Map.get(n2);
            if (count != null && count > 0) {
                result[resultCount] = n2;
                resultCount++;
                count--;
                num1Map.put(n2, count);
            }
        }
        return Arrays.copyOfRange(result, 0, resultCount);
    }
}
// @lc code=end

