package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-22 11:46
 * @Description 对两个字符串形式的二进制数字执行加法运算，最后的计算结果也以二进制字符串形式返回
 * @return null
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String a = "1110";
        String b = "1011";
        String result = solution.addBinary(a, b);
        System.out.println(result);
    }

    /**********************************Add Binary**********************************/
//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 
// 👍 4605 👎 509

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            /*int num = Math.max(a.length(), b.length());
            StringBuilder stringBuilder = new StringBuilder();
            //carry表示进位
            int carry = 0;
            for (int i = 0; i < num; i++) {
                int p = 0;
                int q = 0;
                //0的ASCII码为48，1的ASCII码为49
                //两个数字的数位都没有溢出时
                if (i < a.length() && i < b.length()) {
                    p = a.charAt(a.length() - 1 - i) - '0';
                    q = b.charAt(b.length() - 1 - i) - '0';
                } else if (i < a.length() && i >= b.length()) {
                    //若b溢出了，则b的溢出位补零处理
                    p = a.charAt(a.length() - 1 - i) - '0';
                    q = 0;
                } else if (i >= a.length() && i < b.length()) {
                    //若a溢出了，则b的溢出位补零处理
                    p = 0;
                    q = b.charAt(b.length() - 1 - i) - '0';
                }
                //计算当前位的数字
                int realNum = (p + q + carry) % 2;
                stringBuilder.insert(0, realNum);
                //计算进位
                carry = p + q + carry > 1 ? 1 : 0;
            }
            //若循环结束后，进位仍为1，表明此时需要在最左侧补一位1
            if (carry == 1) {
                stringBuilder.insert(0, 1);
            }
            return stringBuilder.toString();*/


            String res = "";
            int m = a.length() - 1;
            int n = b.length() - 1;
            int carry = 0;
            while (m >= 0 || n >= 0) {
                int p = m >= 0 ? a.charAt(m--) - '0' : 0;
                int q = n >= 0 ? b.charAt(n--) - '0' : 0;
                int sum = p + q + carry;
                res = String.valueOf(sum % 2) + res;
                carry = sum / 2;
            }
            return carry == 1 ? "1" + res : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}