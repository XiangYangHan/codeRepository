package lc.book.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal instance = new PostorderTraversal();
        TreeNode node = TreeNode.generateTreeNode(new Integer[]{1, null, 2, 3, 4, 5, null, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14});
        instance.postorderTraversal(node);
        System.out.println(instance.traversal);
    }

    List<Integer> traversal = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderIterationTraversal(root);
        return traversal;
    }

    public void postorderRecursionTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        traversal.add(node.val);
    }

    public void postorderIterationTraversal(TreeNode node) {
        Set<TreeNode> nodeSet = new HashSet<>(); // 存放处理过右子树的节点
        TreeNode p = node;
        Deque<TreeNode> deque = new LinkedList<>();
        while (p != null || !deque.isEmpty()) {
            if (p != null) {
                deque.push(p);
                p = p.left;
            } else {
                p = deque.pop();
                if (nodeSet.add(p)) {
                    // add 成功则说明还未处理右子树，继续放入栈中，去处理右子树
                    deque.push(p);
                    p = p.right;
                } else {
                    // 已经处理过右子树则处理当前节点
                    traversal.add(p.val);
                    p = null; // 继续出栈
                }
            }
        }
    }

    public void postorderIterationTraversal_2(TreeNode root) {
        TreeNode p = root;
        Deque<TreeNode> deque = new LinkedList<>();
        while (p != null || !deque.isEmpty()) {
            if (p != null) {
                traversal.add(p.val);
                deque.push(p);
                p = p.right;
            } else {
                p = deque.pop().left;
            }
        }
        Collections.reverse(traversal);
    }
}
