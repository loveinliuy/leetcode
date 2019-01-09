package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int cur = sum - root.val;
        if (root.left == null && root.right == null && cur == 0) {
            return true;
        }
        return hasPathSum(root.left, cur) || hasPathSum(root.right, cur);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNodeHelper.newTreeNode2();
        node.print();
        System.out.println(new PathSum().hasPathSum(node, 9));
    }
}
