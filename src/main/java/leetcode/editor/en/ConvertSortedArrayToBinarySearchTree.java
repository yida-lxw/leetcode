package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

/**
 * @Author yida
 * @Date 2022-02-24 15:22
 * @Description 将给定的升序数组转化为高度平衡搜索二叉树
 * 高度平衡二叉树是指一个二叉树的每个节点的左右子树的深度之差的绝对值不超过1
 * @return null
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode binaryTree = solution.sortedArrayToBST(arr);
        BinaryTreeUtils.printBinaryTree(binaryTree);

    }

/**********************************Convert Sorted Array to Binary Search Tree**********************************/
//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// A height-balanced binary tree is a binary tree in which the depth of the two 
//subtrees of every node never differs by more than one. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree 
// 👍 5808 👎 340

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return convertToBST(nums, 0, nums.length - 1);

        /*if (nums == null || nums.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        //数组最大索引值入栈
        stack.add(nums.length - 1);
        //数组最小索引值入栈
        stack.add(0);

        Stack<TreeNode> tree = new Stack<TreeNode>();
        TreeNode root = new TreeNode(0);
        tree.add(root);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            //求出中间节点索引值
            int mid = left + (right - left) / 2;
            TreeNode node = tree.pop();
            //更新根节点值
            node.val = nums[mid];

            //计算左叶子节点最大最小索引值
            int r = mid - 1;
            int l = left;
            //如果存在左叶子节点
            if (l <= r) {
                node.left = new TreeNode(0);
                tree.add(node.left);

                //对应右索引值入栈
                stack.push(r);
                //对应左索引值入栈
                stack.push(l);
            }

            //计算右节点最大最小索引值
            l = mid + 1;
            r = right;
            if (l <= r) {
                node.right = new TreeNode(0);
                tree.add(node.right);

                //对应右索引值入栈
                stack.push(r);
                //对应左索引值入栈
                stack.add(l);
            }
        }
        return root;*/
        }

        public TreeNode convertToBST(int[] nums, int begin, int end) {
            if (begin > end) {
                return null;
            }
            //取中值
            int mid = begin + (end - begin) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            //左叶子树
            root.left = convertToBST(nums, begin, mid - 1);
            //右叶子树
            root.right = convertToBST(nums, mid + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}