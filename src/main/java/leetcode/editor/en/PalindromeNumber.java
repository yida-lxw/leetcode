package leetcode.editor.en;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        int x = 121;
        boolean result = solution.isPalindrome(x);
        System.out.println(x + " is Palindrome number: " + result);
    }

/**********************************Palindrome Number**********************************/
//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //耗时7ms, while循环的次数还可以减少
    public boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }
        int num = x;
        int y = 0;
        while(x > 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y == num;
    }

    //最优解
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return (x == reverseNum) || (x == (reverseNum / 10));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}