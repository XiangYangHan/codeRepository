package lc.book.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderRecursionTraversal(root, list);
        return list;
    }

    public List<Integer> preorderIterationTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode n = node;
        while (n != null || !deque.isEmpty()) {
            if (n != null) {
                list.add(n.val);
                deque.push(n);
                n = n.left;
            } else {
                n = deque.pop();
                n = n.right;
            }
        }
        return list;
    }

    public void preorderRecursionTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorderRecursionTraversal(node.left, list);
        preorderRecursionTraversal(node.right, list);
    }


}
