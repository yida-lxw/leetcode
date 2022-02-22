package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-22 10:56
 * @Description 返回一句话中最后一个单词的长度
 * @return null
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        String s = "  Hello World, I like Java  ";
        int len = solution.lengthOfLastWord(s);
        System.out.println(len);
    }

    /**********************************Length of Last Word**********************************/
//Given a string s consisting of some words separated by some number of spaces, 
//return the length of the last word in the string. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
// 
//
// Example 2: 
//
// 
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
// 
//
// Example 3: 
//
// 
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of only English letters and spaces ' '. 
// There will be at least one word in s. 
// 
// Related Topics String 
// 👍 667 👎 58

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int right = s.length() - 1;
            int res = 0;
            //如果最右侧一直都是空格，则right索引一直左移，相当于忽略最右侧的所有空格
            while (right >= 0 && s.charAt(right) == ' ') {
                --right;
            }
            //忽略完最右侧的所有空格之后，开始统计非空格字符的个数，直到遇到空格字符为止。
            while (right >= 0 && s.charAt(right) != ' ') {
                --right;
                ++res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}