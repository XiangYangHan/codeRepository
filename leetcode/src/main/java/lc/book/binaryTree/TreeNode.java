package lc.book.binaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTreeNode(Integer[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        int left = 1,right = 2;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (left < data.length) {
            TreeNode node = nodes.poll();
            if (Objects.nonNull(data[left])) {
                node.left = new TreeNode(data[left]);
                nodes.offer(node.left);
            }
            if (right < data.length && Objects.nonNull(data[right])) {
                node.right = new TreeNode(data[right]);
                nodes.offer(node.right);
            }
            left += 2;
            right += 2;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = generateTreeNode(new Integer[]{});
        root = generateTreeNode(new Integer[]{1});
        root = generateTreeNode(new Integer[]{1, null});
        root = generateTreeNode(new Integer[]{1, null, 2});
        root = generateTreeNode(new Integer[]{1, null, 2, null});
        root = generateTreeNode(new Integer[]{1, null, 2, null, 3});
        root = generateTreeNode(new Integer[]{1, null, 2, null, 3, null});
        root = generateTreeNode(new Integer[]{1,null,2,3,4,5,null,6,7,8,9,10,11,12,13,null,null, 14});
    }
}