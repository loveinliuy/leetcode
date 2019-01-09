package h1.t1;

import utils.TreeNode;

/**
 * @author zhangshibo
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node) {
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
