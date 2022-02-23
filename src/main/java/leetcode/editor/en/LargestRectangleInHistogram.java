package leetcode.editor.en;

import java.util.Stack;

/**
 * @Author yida
 * @Date 2022-02-23 17:10
 * @Description 求给定柱状图的最大矩形面积
 * @return null
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int area = solution.largestRectangleArea(heights);
        System.out.println("area:" + area);
    }

    /**********************************Largest Rectangle in Histogram**********************************/
//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 105 
// 0 <= heights[i] <= 104 
// 
// Related Topics Array Stack Monotonic Stack 
// 👍 9140 👎 136

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= heights.length; ++i) {
                while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                    final int h = heights[stack.pop()];
                    final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}