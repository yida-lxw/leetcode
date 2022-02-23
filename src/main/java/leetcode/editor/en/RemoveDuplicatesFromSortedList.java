package leetcode.editor.en;

import leetcode.editor.en.bean.ListNode;
import leetcode.editor.en.utils.LinkedListUtils;

/**
 * @Author yida
 * @Date 2022-02-22 18:28
 * @Description 给定一个已排序链表的头结点，删除此链接的重复元素使得每个元素只出现一次，<br/>
 * 最后按照原来的排序顺序返回该链表
 * @return null
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        /*ListNode l1 = new ListNode(3, null);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(1, l4);*/

        ListNode l3 = new ListNode(1, null);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(1, l4);

        LinkedListUtils.printLinkedList(l5);
        ListNode finalListNode = solution.deleteDuplicates(l5);
        LinkedListUtils.printLinkedList(finalListNode);
    }

/**********************************Remove Duplicates from Sorted List**********************************/
//Given the head of a sorted linked list, delete all duplicates such that each e
//lement appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List 
// 👍 4256 👎 177

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode curr = head;
            //内层循环是一个等差数列，等差数列是一个关于n的一次函数，即O(n),
            // 外层循环是n次，即n个关于n的一次函数相加，最终肯定还是一个关于n的一次函数，即O(n)。
            while (curr != null) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}