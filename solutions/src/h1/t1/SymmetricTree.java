package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangshibo
 */
public class SymmetricTree {

    public boolean isSymmetricB(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isRowSymmetric(Collections.singletonList(root));
    }

    private boolean isRowSymmetric(List<TreeNode> nodes) {
        if (!isOneRowSymmetric(nodes)) {
            return false;
        }
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                list.add(node.left);
                list.add(node.right);
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        return isRowSymmetric(list);
    }

    private boolean isOneRowSymmetric(List<TreeNode> nodes) {
        int i = 0;
        int j = nodes.size() - 1;
        while (i < j) {
            TreeNode low = nodes.get(i);
            TreeNode high = nodes.get(j);
            i++;
            j--;
            if (low == null && high == null) {
            } else if (low == null) {
                return false;
            } else if (high == null) {
                return false;
            } else if (low.val != high.val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNodeHelper.newTreeNode();
        node.print();
        System.out.println(new SymmetricTree().isSymmetricB(node));
    }
}
