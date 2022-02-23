package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-22 17:56
 * @Description 求n级楼梯，爬到顶部有几种走法
 * @return null
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int n = 12;
        int steps = solution.climbStairs(n);
        System.out.println(steps);
    }

    /**********************************Climbing Stairs**********************************/
//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 
// 👍 10499 👎 323

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            //递归方式解决：f(x) = f(x-1) + f(x-2)
        /*if(n<=0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);*/

            //动态规划：dp[n] = dp[n-1] + dp[n-2]
        /*int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];*/

            //斐波那契数列公式直接计算，时间复杂度O(1)
            double sqrt_5 = Math.sqrt(5);
            double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
            return (int) (fib_n / sqrt_5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}