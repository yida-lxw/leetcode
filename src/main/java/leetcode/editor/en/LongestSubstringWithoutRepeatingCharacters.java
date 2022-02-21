package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s= "abcdc12345";
        int len = solution.lengthOfLongestSubstring(s);
        System.out.println(len);
    }

/**********************************Longest Substring Without Repeating Characters**********************************/
//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = s.length();
        int i = 0, j = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (; j < length; ++j){
            if (hashMap.containsKey(s.charAt(j))){
                //找到重复的字符之后，那么下一次查找就从之前的这个字符的下一个字符的位置开始
                i = Math.max(hashMap.get(s.charAt(j)) + 1, i);
            }
            //计算最长子串的长度(从新的起点计算子串长度)
            maxLength = Math.max(maxLength, j - i + 1);
            hashMap.put(s.charAt(j), j);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}