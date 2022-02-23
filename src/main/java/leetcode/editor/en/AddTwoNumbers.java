package leetcode.editor.en;

import leetcode.editor.en.bean.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(3, null);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);


        ListNode l4 = new ListNode(4, null);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);

        ListNode listNode = solution.addTwoNumbers(l3, l6);
        System.out.println(listNode);
    }

/**********************************Add Two Numbers**********************************/
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            //进位
            int carry = 0;
            while (l1 != null || l2 != null) {
                int d1 = (l1 == null) ? 0 : l1.val;
                int d2 = (l2 == null) ? 0 : l2.val;
                int sum = d1 + d2 + carry;
                carry = sum >= 10 ? 1 : 0;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
