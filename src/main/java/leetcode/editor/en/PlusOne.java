package leetcode.editor.en;

import java.util.Arrays;

/**
 * @Author yida
 * @Date 2022-02-22 11:24
 * @Description 将一个使用整型数组表示的大数字执行加1操作，返回最后的整型数组
 * @return null
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = {8, 9, 9, 9};
        System.out.println(Arrays.toString(digits));
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    /**********************************Plus One**********************************/
//You are given a large integer represented as an integer array digits, where ea
//ch digits[i] is the ith digit of the integer. The digits are ordered from most s
//ignificant to least significant in left-to-right order. The large integer does n
//ot contain any leading 0's. 
//
// Increment the large integer by one and return the resulting array of digits. 
//
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
// 
//
// Example 3: 
//
// 
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// digits does not contain any leading 0's. 
// 
// Related Topics Array Math 
// 👍 3700 👎 3963

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int size = digits.length;
            //从最低位-个位开始判断，故需要从数组的末尾向首位开始判断
            for (int i = size - 1; i >= 0; i--) {
                //如果当前位小于9，则直接当前位加1即可
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                //否则需要将当前位置为零，然后从当前位到首位的每一位都加1
                digits[i] = 0;
            }
            //达到这里说明数组中的数字全是9，此时需要对数组扩容一位，首位为1，其他位都是为默认值零。
            int[] arr = new int[size + 1];
            arr[0] = 1;
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}