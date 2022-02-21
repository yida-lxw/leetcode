package leetcode.editor.en;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        String haystack = "hello";
        String needle = "ll";
        int result = solution.strStr(haystack, needle);
        System.out.println(result);
    }

    /**********************************Implement strStr()**********************************/
//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics Two Pointers String String Matching 
// 👍 3581 👎 3361

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @return int
         * @Author yida
         * @Date 2022-02-21 19:28
         * @Description 返回子串在主串中第一次出现的位置，
         * 最优解为KMP算法
         */
        public int strStr(String haystack, String needle) {
        /*final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i < m - n + 1; ++i) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;*/

            final int m = haystack.length();
            final int n = needle.length();

            if (n == 0) {
                return 0;
            }

            char[] T = haystack.toCharArray();
            char[] P = needle.toCharArray();
            int[] next = getNext(needle);
            int i = 0;
            int j = 0;

            while (i < m && j < n) {
                //当j == -1时，i向后移动一位，j也要归零
                if (j == -1 || T[i] == P[j]) {
                    i++;
                    j++;
                } else {
                    //T[i] != P[j]时，i指针不用动，j指针移动到相应的位置
                    j = next[j];
                }
            }

            //说明在主串T中找到了模式串P
            if (j == n) {
                return i - j;
            }
            return -1;
        }

        /**
         * 根据模式串P获取next数组，next[j]表示P[j]匹配失败后，j指针应指向的位置。
         *
         * @param P 模式串
         * @return next数组
         */
        public int[] getNext(String P) {
            int len = P.length();
            int[] next = new int[len];
            next[0] = -1;
            //存储当前next[j]对应的k值
            int k = -1;

            int j = 0;
            while (j < len - 1) {
                //隐含条件P[0 ... k-1] == P[j-k ... j-1]
                if (k == -1 || P.charAt(k) == P.charAt(j)) {
                    //当k == -1时，next[j++] = 0，例如next[1] = 0，或者前j字符没有相同前缀后缀时也为0。
                    //当P[k] == P[j]时，由于P[0 ... k-1] == P[j-k ... j-1]，
                    // 则此时P[0 ... k] == P[j-k ... j]，所以此时next[j+1] = k+1
                    next[++j] = ++k;
                } else {
                    //当P[k] != P[j]时，next[j+1]必定小于k，此时可以缩小k的值（最小小到-1）
                    k = next[k];
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}