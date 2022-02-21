package leetcode.editor.en;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(4, node1);
        ListNode node4 = new ListNode(4, node2);
        ListNode node5 = new ListNode(2, node3);
        ListNode node6 = new ListNode(3, node4);
        ListNode node7 = new ListNode(1, node5);
        ListNode node8 = new ListNode(1, node6);

        ListNode listNode = solution.mergeTwoLists(node7, node8);
        ListNode root = new ListNode(-1, listNode);
        ListNode next = root.next;

        while (null != next) {
            System.out.print(next.val + ",");
            root = root.next;
            next = root.next;
        }
        System.out.println();
    }

/**********************************Merge Two Sorted Lists**********************************/
//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists. 
//
// Example: 
//
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }
        // 把未结束的链表连接到合并后的链表尾部
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}