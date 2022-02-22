package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-22 14:38
 * @Description 计算并返回给定的非负整数x的平方根的整数部分
 * @return null
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        int x = 27;
        int result = solution.mySqrt(x);
        System.out.println(result);
    }

    /**********************************Sqrt(x)**********************************/
//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned. 
//
// Note: You are not allowed to use any built-in exponent function or operator, 
//such as pow(x, 0.5) or x ** 0.5. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics Math Binary Search 
// 👍 3356 👎 3022

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            //二分法求一个正整数的平方根
        /*if (x < 1) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            //求中间数，之所以不用mid = (right+left)/2，是因为right+left可能会溢出
            int mid = (high - low) / 2 + low;
            //判断mid的平方是否等于x，之所以不用mid*mid == x，是因为mid的平方可能会溢出
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                //若mid的平方小于x,说明mid比x的平方根要小
                low = mid + 1;
            } else if (x / mid < mid) {
                //若mid的平方大于x,说明mid比x的平方根要大
                high = mid - 1;
            }
        }
        return high;*/

            //牛顿迭代法求一个正整数的平方根
            double flag = 0d;
            if (x <= 0) {
                return 0;
            }
            double val = x;
            double last;
            do {
                last = val;
                val = (val + x / val) / 2;
            } while (val - last > flag || val - last < -flag);
            return (int) val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}