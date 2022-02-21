package leetcode.editor.en;

import java.util.HashMap;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        int columnNumber = 701;
        String columnTitle = solution.convertToTitle(columnNumber);
        System.out.println(columnTitle);
    }

    /**********************************Excel Sheet Column Title**********************************/
//Given an integer columnNumber, return its corresponding column title as it app
//ears in an Excel sheet. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnNumber = 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: columnNumber = 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: columnNumber = 701
//Output: "ZY"
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnNumber <= 231 - 1 
// 
// Related Topics Math String 
// 👍 2465 👎 387

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            HashMap<Integer, Character> hashMap = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                hashMap.put(i, (char) ('A' + i));
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (columnNumber-- >= 0) {
                stringBuilder.append(hashMap.get(columnNumber % 26));
                columnNumber /= 26;
                if (0 == columnNumber) {
                    break;
                }
            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}