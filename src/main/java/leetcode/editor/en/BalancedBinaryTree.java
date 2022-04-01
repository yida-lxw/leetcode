package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author yida
 * @Date 2022-02-24 15:48
 * @Description 判断给定二叉树是否为平衡二叉树
 * @return null
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        Integer[] arr = {1, 2, 2, 3, 3, 4, 4};
        TreeNode binaryTree = BinaryTreeUtils.createBT(arr);
        BinaryTreeUtils.printBinaryTree(binaryTree);
        boolean balanced = solution.isBalanced(binaryTree);
        System.out.println(balanced);
    }

/**********************************Balanced Binary Tree**********************************/
//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 5212 👎 288

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
        public boolean isBalanced(TreeNode root) {
            //递归版
        /*if(root == null) {
            return true;
        }
        if(Math.abs(BinaryTreeUtils.getTreeDepth(root.left) - BinaryTreeUtils.getTreeDepth(root.right)) <= 1) {
            return true && isBalanced(root.left) && isBalanced(root.right);
        }
        return false;*/

            if (null == root) {
                return true;
            }
            TreeNode node = root;
            // 前一个遍历过的节点, 协助判断根节点的右子树是否已遍历
            TreeNode preNode = null;
            // 用 LinkedList 代替实现 Stack
            List<TreeNode> nodeList = new LinkedList<>();
            // 保存nodeList中当前节点左右子树的高度, childHeight[0]: 左子树高, childHeight[1]: 右子树高
            List<int[]> childHeightList = new LinkedList<>();
            while (nodeList.size() > 0 || null != node) {
                // 遍历左子树
                while (null != node) {
                    nodeList.add(0, node);
                    childHeightList.add(0, new int[]{null == node.left ? 0 : 1, null == node.right ? 0 : 1});
                    node = node.left;
                }
                // 子树根节点
                node = nodeList.get(0);
                // 没有右子树或者右子树已经遍历过
                if (null == node.right || node.right == preNode) {
                    nodeList.remove(0);
                    int[] nodeChildHeight = childHeightList.remove(0);
                    // 判断当前是否平衡, 不平衡就直接return
                    if (Math.abs(nodeChildHeight[0] - nodeChildHeight[1]) > 1) {
                        return false;
                    }
                    // 更新父节点左右子树高度
                    if (nodeList.size() > 0) {
                        TreeNode parentNode = nodeList.get(0);
                        int[] parentNodeChildHeight = childHeightList.get(0);
                        int h = Math.max(nodeChildHeight[0], nodeChildHeight[1]);
                        if (parentNode.left == node) {
                            parentNodeChildHeight[0] += h;
                        } else {
                            parentNodeChildHeight[1] += h;
                        }
                    }
                    // 准备遍历下一节点
                    preNode = node;
                    node = null;
                    continue;
                }
                // 遍历右子树
                node = node.right;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}