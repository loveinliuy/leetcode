package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class MaxiumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        int[] max = {0};
        depth(root, 1, max);
        return max[0];
    }

    private void depth(TreeNode node, int curDepth, int[] maxDepth) {
        if (node == null) {
            return;
        }
        maxDepth[0] = Math.max(curDepth, maxDepth[0]);
        depth(node.left, curDepth + 1, maxDepth);
        depth(node.right, curDepth + 1, maxDepth);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNodeHelper.newTreeNode2();
        int depth = new MaxiumDepthOfBinaryTree().maxDepth(node);
        System.out.println(depth);
    }

}
