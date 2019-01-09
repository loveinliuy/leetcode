package h1.t1;

import utils.TreeNode;
import utils.TreeNodeHelper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangshibo
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        search(Collections.singletonList(root), result);
        Collections.reverse(result);
        return result;
    }

    private void search(List<TreeNode> nodes, List<List<Integer>> list) {
        List<Integer> line = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                line.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
        }
        list.add(line);
        if (!next.isEmpty()) {
            search(next, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.newTreeNode();
        System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root));
    }
}
