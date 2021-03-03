package lc.book.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    private List<Integer> traversalList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        return traversalList;
    }

    public void inorderRecursionTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        traversalList.add(root.val);
        inorderTraversal(root.right);
    }

    public void inorderIterationTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null || deque.size() > 0) {
            if (node != null) {
                deque.push(node);
                node = node.left;
            } else {
                node = deque.pop();
                traversalList.add(node.val);
                node = node.right;
            }
        }
    }


}
