package leetcode.editor.en.utils;

import leetcode.editor.en.ListNode;

/**
 * @Author yida
 * @Date 2022-02-22 19:12
 * @Description LinkedList工具类
 */
public class LinkedListUtils {
    /**
     * @return void
     * @Author yida
     * @Date 2022-02-22 19:15
     * @Description 打印LinkedList链表
     */
    public static void printLinkedList(ListNode listNode) {
        ListNode root = new ListNode(-1, listNode);
        ListNode next = root.next;
        while (null != next) {
            if (next.next != null) {
                System.out.print(next.val + "->");
            } else {
                System.out.print(next.val);
            }
            root = root.next;
            next = root.next;
        }
        System.out.println();
    }
}
