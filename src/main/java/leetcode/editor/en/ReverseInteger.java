package leetcode.editor.en;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int x = 123456789;
        int y = solution.reverse(x);
        System.out.println("before reverse: " + x);
        System.out.println("after  reverse: " + y);
    }

/**********************************Reverse Integer**********************************/
//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        //因为反转后数据可能超出int的最大取值范围，故需要使用long类型来接收返回值
        //res刚开始表示个位
        long res = 0;
        while (x != 0) {
            //res每次乘以10来升位，x % 10用来计算当前的个位
            res = res * 10 + x % 10;
            //x每次除以10来降位
            x /= 10;
            //判断返回值是否已经超出int的取值范围，防止数据溢出
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}