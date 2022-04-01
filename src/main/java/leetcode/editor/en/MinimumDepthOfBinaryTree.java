package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yida
 * @Date 2022-02-24 18:57
 * @Description 计算给定二叉树的最小深度
 * @return null
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        Integer[] arr = {1, null, 2, null, 3, null, 4, null, 5};
        TreeNode binaryTree = BinaryTreeUtils.createBT(arr);
        BinaryTreeUtils.printBinaryTree(binaryTree);
        int minDepth = solution.minDepth(binaryTree);
        System.out.println(minDepth);
    }

/**********************************Minimum Depth of Binary Tree**********************************/
//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 3757 👎 930

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
        public int minDepth(TreeNode root) {
            //递归版实现
            /*if (root == null) {
                return 0;
            }
            //左子树为空，右子树不为空，则右子树的最大深度+1就是我们要计算的最小深度
            if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            }
            //右子树为空，左子树不为空，则左子树的最大深度+1就是我们要计算的最小深度
            if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            }
            //左右子树都不为空，则返回左子树的最大深度和右子树的最大深度之间的较小者作为最终的最小深度
            return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);*/

            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int minDepth = 0;
            while (!queue.isEmpty()) {
                int count = queue.size();
                minDepth++;
                while (count > 0) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left == null && treeNode.right == null) {
                        return minDepth;
                    }
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                    count--;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}