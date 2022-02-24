package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yida
 * @Date 2022-02-23 19:47
 * @Description 判断两个二叉树是否相等
 * @return null
 */
public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode binaryTreeP = BinaryTreeUtils.createBT(arr, 0);
        TreeNode binaryTreeQ = BinaryTreeUtils.createBT(arr, 0);
        boolean isSame = solution.isSameTree(binaryTreeP, binaryTreeQ);
        System.out.println(isSame);
    }

/**********************************Same Tree**********************************/
//Given the roots of two binary trees p and q, write a function to check if they
// are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
//
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 5102 👎 123

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
        /**
         * 递归版解题思路：
         * 1. If both trees are empty then return 1.
         * 2. Else If both trees are non -empty
         *      (a) Check data of the root nodes (tree1->data ==  tree2->data)
         *      (b) Check left subtrees recursively  i.e., call sameTree(
         *           tree1->left_subtree, tree2->left_subtree)
         *      (c) Check right subtrees recursively  i.e., call sameTree(
         *           tree1->right_subtree, tree2->right_subtree)
         *      (d) If a,b and c are true then return 1.
         * 3  Else return 0 (one is empty and other is not)
         */
        /*public boolean isSameTree(TreeNode p, TreeNode q) {
            //若两个二叉树都为空，则返回true
            if(null == p && null == q) {
                return true;
            }
            //若两个二叉树其中一个为空，另一个不为空，则返回false
            if((null == p && null != q) || (null == q && null != p)) {
                return false;
            }
            //若两个二叉树都不为空
            boolean a = p.val ==  q.val;
            //判断两个二叉树的左子树是否相等
            boolean b = isSameTree(p.left, q.left);
            //判断两个二叉树的右子树是否相等
            boolean c = isSameTree(p.right, q.right);
            return a && b && c;
        }*/

        /**
         * @return boolean
         * @Author yida
         * @Date 2022-02-24 11:31
         * @Description 判断两个二叉树是否相等(非递归版)
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //如果都为空我们就认为他们是相同的
            if (p == null && q == null) {
                return true;
            }
            //如果一个为空，一个不为空，很明显不可能是相同的树，直接返回false即可
            if (p == null || q == null) {
                return false;
            }
            Queue<TreeNode> queueP = new LinkedList<>();
            Queue<TreeNode> queueQ = new LinkedList<>();
            //如果p和q两个节点都不为空，就把他们加入到队列中
            queueP.add(p);
            queueQ.add(q);
            while (!queueP.isEmpty() && !queueQ.isEmpty()) {
                //分别出队
                TreeNode tempP = queueP.poll();
                TreeNode tempQ = queueQ.poll();
                //如果这两个节点的值不相同，直接返回false
                if (tempP.val != tempQ.val) {
                    return false;
                }

                //如果对应的左子节点不为空就加入到队列中
                if (tempP.left != null) {
                    queueP.add(tempP.left);
                }
                if (tempQ.left != null) {
                    queueQ.add(tempQ.left);
                }
                //注意这里没有直接判断两个左子节点是否一个为空一个
                //不为空，而是通过队列的长度来判断的，只有两个左子节点
                //都为空或者都不为空的时候，队列长度才会一样
                if (queueP.size() != queueQ.size()) {
                    return false;
                }

                //右子节点的处理方式跟左子节点类似
                if (tempP.right != null) {
                    queueP.add(tempP.right);
                }
                if (tempQ.right != null) {
                    queueQ.add(tempQ.right);
                }
                if (queueP.size() != queueQ.size()) {
                    return false;
                }
            }
            //最后再判断这两个队列是否都为空
            return queueP.isEmpty() && queueQ.isEmpty();
        }

        /**
         * @return Integer>
         * @Author yida
         * @Date 2022-02-24 11:07
         * @Description 从上至下，从左至右打印二叉树
         */
        public List<Integer> printFromTopToBottom(TreeNode treeRoot) {
            List<Integer> list = new ArrayList<Integer>();
            if (null == treeRoot) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(treeRoot);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                list.add(treeNode.val);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}