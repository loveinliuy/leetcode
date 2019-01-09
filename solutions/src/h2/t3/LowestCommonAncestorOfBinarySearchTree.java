package h2.t3;

import utils.TreeNode;

import javax.sound.midi.Soundbank;

/**
 * @author zhangshibo
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        } else if (p.val >= root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    public TreeNode lowestCommonAncestorB(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(6);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(8);
//        TreeNode n4 = new TreeNode(0);
//        TreeNode n5 = new TreeNode(4);
//        TreeNode n6 = new TreeNode(7);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;

        n1.print();
        TreeNode node = new LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestorB(n1, n1, n2);
        node.print();
    }

}
