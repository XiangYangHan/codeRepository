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
        deque.push(node);
        while (!deque.isEmpty()) {
            TreeNode peek = deque.pop();
            if (peek == null) {
                continue;
            }
            list.add(peek.val);
            deque.push(peek.right);
            deque.push(peek.left);
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
