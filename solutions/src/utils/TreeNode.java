package utils;

/**
 * @author zhangshibo
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }

    public void print() {
        printTree(this, 0, "H", 10);
    }

    private static void printTree(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printTree(head.right, height + 1, "v", len);

        String val = to + head.val + to;
        int lenV = val.length();
        int lenL = (len - lenV) / 2;
        int lenR = len - lenV - lenL;
        System.out.println(getSpace(len * height) + getSpace(lenL) + val + getSpace(lenR));

        printTree(head.left, height + 1, "^", len);
    }

    private static String getSpace(int len) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(" ");
        }
        return str.toString();
    }
}
