package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yida
 * @Date 2022-02-24 14:06
 * @Description 计算给定二叉树的最大深度
 * @return null
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode binaryTree = BinaryTreeUtils.createBT(arr);
        BinaryTreeUtils.printBinaryTree(binaryTree);
        int maxDepth = solution.maxDepth(binaryTree);
        System.out.println(maxDepth);
    }

/**********************************Maximum Depth of Binary Tree**********************************/
//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path f
//rom the root node down to the farthest leaf node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 6353 👎 119

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
        public int maxDepth(TreeNode root) {
            //递归版
            /*if (root == null) {
                return 0;
            }
            //计算左子树的最大深度
            int leftMaxDepth = maxDepth(root.left);
            //计算右子树的最大深度
            int rightMaxDepth = maxDepth(root.right);
            //以某个节点为根节点的数的最大深度为max
            return Math.max(leftMaxDepth, rightMaxDepth) + 1;*/

            if (root == null) {
                return 0;
            }
            //BFS的层次遍历思想，记录二叉树的层数，
            //遍历完，层数即为最大深度
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                //每遍历完一个TreeNode 层数加1
                maxDepth++;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    //检查每一个节点
                    TreeNode node = queue.pollFirst();
                    //检查是否有左孩子
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    //检查是否有右孩子
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return maxDepth;
        }
    }

    public int calculateMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //使用双端队列
        Deque<TreeNode> queue = new LinkedList<>();
        //把根节点加入到队列中
        queue.offer(root);
        //根节点的值我们把它修改为1
        root.val = 1;
        //记录最大的宽度
        int maxWide = 0;
        while (!queue.isEmpty()) {
            //当前层节点的数量
            int levelCount = queue.size();
            //当前层最左边节点的值
            int left = queue.peekFirst().val;
            //当前层最右边节点的值
            int right = queue.peekLast().val;
            //当前层的最大宽度就是right - left + 1，
            //这里计算之后要保留最大的
            maxWide = Math.max(maxWide, right - left + 1);
            //遍历当前层的所有节点，把他们的子节点在加入到队列中
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                int position = node.val;
                //如果左子节点不为空，就把左子节点加入到队列中
                if (node.left != null) {
                    node.left.val = position * 2;
                    queue.offer(node.left);
                }
                //如果右子节点不为空，就把右子节点加入到队列中
                if (node.right != null) {
                    node.right.val = position * 2 + 1;
                    queue.offer(node.right);
                }
            }
        }
        return maxWide;
    }
//leetcode submit region end(Prohibit modification and deletion)

}