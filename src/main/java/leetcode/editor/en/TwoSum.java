package leetcode.editor.en;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new TwoSum().new Solution();
        int[] res = solution.twoSum(nums, target);
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        for (int str : res) {
            if( i == 0) {
                builder.append(str);
            } else {
                builder.append(",").append(str);
            }
            i++;
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

/**********************************Two Sum**********************************/
//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}