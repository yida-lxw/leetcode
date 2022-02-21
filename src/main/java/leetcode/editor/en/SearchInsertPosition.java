package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-21 19:40
 * @Description 返回指定数字在升序数组中的索引位置
 * @return null
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    /**********************************Search Insert Position**********************************/
//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 6828 👎 382

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length;

            while (l < r) {
                //计算当前的中间位置
                final int m = l + (r - l) / 2;
                if (nums[m] == target) {
                    return m;
                }
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}