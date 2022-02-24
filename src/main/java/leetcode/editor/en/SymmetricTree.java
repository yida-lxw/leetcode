package leetcode.editor.en;

import leetcode.editor.en.bean.TreeNode;
import leetcode.editor.en.utils.BinaryTreeUtils;

import java.util.LinkedList;

/**
 * @Author yida
 * @Date 2022-02-24 11:37
 * @Description 判断给定的二叉树是否为对称二叉树
 * @return null
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode binaryTree = BinaryTreeUtils.createBT(arr);
        boolean isSymmetric = solution.isSymmetric(binaryTree);
        System.out.println(isSymmetric);
    }

/**********************************Symmetric Tree**********************************/
//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 8722 👎 217

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
        public boolean isSymmetric(TreeNode root) {
        /*if(root == null) {
            return true;
        }
        return isMirror(root.left,root.right);*/

            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            //用队列保存节点
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            //将根节点的左右孩子放到队列中
            queue.add(root.left);
            queue.add(root.right);
            while (queue.size() > 0) {
                //从队列中取出两个节点，再比较这两个节点
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                //如果两个节点都为空就继续循环，
                if (left == null && right == null) {
                    continue;
                }
                //若左右子树两者有一个为空而另一个不为空，则返回false
                if (left == null || right == null) {
                    return false;
                }
                //若左子树与右子树的值不相等，则说明不是对称二叉树
                if (left.val != right.val) {
                    return false;
                }
                //将左节点的左孩子， 右节点的右孩子放入队列
                queue.add(left.left);
                queue.add(right.right);
                //将左节点的右孩子，右节点的左孩子放入队列
                queue.add(left.right);
                queue.add(right.left);
            }
            return true;
        }

        //递归判断左右子树是否对称
        boolean isMirror(TreeNode l, TreeNode r) {
            if (l == null && r == null) {
                return true;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            return isMirror(l.left, r.right) && isMirror(l.right, r.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}