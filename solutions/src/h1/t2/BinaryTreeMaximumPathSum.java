package h1.t2;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        return 0;
    }


    public static void main(String[] args) {
        TreeNode node = TreeNodeHelper.newTreeNode();
        node.print();
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(node));
    }
}
