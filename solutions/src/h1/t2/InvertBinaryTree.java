package h1.t2;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root){
        invert(root);
        return root;
    }

    private void invert(TreeNode node){
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invert(node.left);
        invert(node.right);
    }

    public static void main(String[] args){

        TreeNode root = TreeNodeHelper.newTreeNode();
        root.print();

        TreeNode result = new InvertBinaryTree().invertTree(root);

        result.print();
    }

}
