package lc.book.binaryTree.recursion;

import lc.book.binaryTree.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth instance = new MaxDepth();
        TreeNode root = TreeNode.generateTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(instance.maxDepth(root));

    }

    public int maxDepth(TreeNode root) {
//        int maxDepth = bottomUpMaxDepth(root);
        int maxDepth = topDownMaxDepth(root, 0, 0);

        return maxDepth;
    }

    /**
     * 自底向上
     */
    public int bottomUpMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }


    /**
     * 自顶向下
     */
    public int topDownMaxDepth(TreeNode node, int depth, int maxDepth) {
        if (node == null) {
            return Math.max(depth, maxDepth);
        }
        maxDepth = topDownMaxDepth(node.left, depth + 1, maxDepth);
        maxDepth = topDownMaxDepth(node.right, depth + 1, maxDepth);
        return maxDepth;
    }

}
