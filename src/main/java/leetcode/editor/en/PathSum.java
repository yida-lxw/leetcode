package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yida
 * @Date 2022-02-25 10:33
 * @Description 给定一个二叉树和一个数字targetSum，判断是否存在这样一条根节点到叶子节点的路径，要求路径中每个数字加起来的和为targetSum
 * @return null
 */
public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode binaryTree = BinaryTreeUtils.createBT(arr);
        BinaryTreeUtils.printBinaryTree(binaryTree);
        int targetNum = 38;
        boolean isHasPathSum = solution.hasPathSum(binaryTree, targetNum);
        System.out.println(isHasPathSum);
    }

/**********************************Path Sum**********************************/
//Given the root of a binary tree and an integer targetSum, return true if the t
//ree has a root-to-leaf path such that adding up all the values along the path eq
//uals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.
// 
//
// Example 3: 
//
// 
//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 4977 👎 761

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            Queue<TreeNode> queNode = new LinkedList<TreeNode>();
            Queue<Integer> queVal = new LinkedList<Integer>();
            queNode.offer(root);
            queVal.offer(root.val);
            while (!queNode.isEmpty()) {
                TreeNode curTreeNode = queNode.poll();
                int curTreeNodeVal = queVal.poll();
                //若二叉树没有左右子树
                if (curTreeNode.left == null && curTreeNode.right == null) {
                    //当最终计算的路径和等于给定值，则返回true
                    if (curTreeNodeVal == targetSum) {
                        return true;
                    }
                    continue;
                }
                //若二叉树的左子树不为空，则开始计算以左子树的根节点作为根节点的子二叉树对应的路径和
                if (curTreeNode.left != null) {
                    queNode.offer(curTreeNode.left);
                    //子二叉树的路径和需要加上它的父节点的路径和
                    queVal.offer(curTreeNode.left.val + curTreeNodeVal);
                }
                //若二叉树的右子树不为空，则开始计算以右子树的根节点作为根节点的子二叉树对应的路径和
                if (curTreeNode.right != null) {
                    queNode.offer(curTreeNode.right);
                    queVal.offer(curTreeNode.right.val + curTreeNodeVal);
                }
            }
            return false;
        }

        //递归版实现
        public boolean hasPathNumWIthRecurise(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && targetSum == root.val) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}