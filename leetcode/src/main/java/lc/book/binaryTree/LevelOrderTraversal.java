package lc.book.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal instance = new LevelOrderTraversal();
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,2})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,2,3})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,null,2})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,null,2,3})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,null,2,3})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1,null,2,null,3})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{1, null, 2, null, 3, 4})));
        System.out.println(instance.levelOrder(TreeNode.generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> levelData = new ArrayList<>();
        TreeNode p;
        while (true) {
            p = queue.poll();
            if (p == null) {
                if (levelData.isEmpty()) {
                    break;
                } else {
                    result.add(levelData);
                    levelData = new ArrayList<>();
                    queue.offer(null);
                }
            } else {
                levelData.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return result;
    }
}
