package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNodeHelper.newTreeNode2();
        node.print();
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(node));
    }
}
