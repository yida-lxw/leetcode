package leetcode.editor.en.utils;

import leetcode.editor.en.bean.TreeNode;

/**
 * @Author yida
 * @Date 2022-02-23 19:21
 * @Description 二叉树操作工具类
 */
public class BinaryTreeUtils {

    /**
     * @return TreeNode
     * @Author yida
     * @Date 2022-02-23 19:25
     * @Description 根据传入的一维数组构建二叉树
     */
    // 初始时,传入的i==0
    public static TreeNode createBT(int[] arr, int i) {
        // 定义根节点
        TreeNode root = null;

        //i >= arr.length 时,表示已经到达了根节点
        if (i >= arr.length) {
            return null;
        }
        // 根节点
        root = new TreeNode(arr[i]);
        // 递归建立左子树
        root.left = createBT(arr, 2 * i + 1);
        // 递归建立右子树
        root.right = createBT(arr, 2 * i + 2);
        return root;
    }
}
