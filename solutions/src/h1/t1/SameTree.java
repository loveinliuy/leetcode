package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

/**
 * @author zhangshibo
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(TreeNodeHelper.newTreeNode2(), TreeNodeHelper.newTreeNode2()));
    }
}
