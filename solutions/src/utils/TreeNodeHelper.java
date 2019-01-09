package utils;

/**
 * @author zhangshibo
 */
public class TreeNodeHelper {

    public static TreeNode newTreeNode(){
        TreeNode root = new TreeNode(4);
        TreeNode subLeft = new TreeNode(2);
        TreeNode subRight = new TreeNode(2);
        root.left = subLeft;
        root.right = subRight;
//        subLeft.left = new TreeNode(1);
//        subLeft.right = new TreeNode(3);
//        subRight.left = new TreeNode(6);
//        subRight.right = new TreeNode(9);
        return root;
    }

    public static TreeNode newTreeNode2(){
        TreeNode root = new TreeNode(4);
        TreeNode subLeft = new TreeNode(2);
        root.right = subLeft;
        TreeNode sub3 = new TreeNode(1);
        subLeft.left = sub3;
        subLeft.right = new TreeNode(3);
        sub3.left = new TreeNode(5);
        return root;
    }
}
