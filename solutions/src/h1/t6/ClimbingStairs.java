package h1.t6;

/**
 * description:
 *
 * @author zhangshibo  [2018/7/26].
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int cur = 0;
        int last1 = 2;
        int last2 = 1;
        for (int i = 2; i < n; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }

//    /**
//     * 发现规律为斐波那契数列
//     * 递归方式超时
//     */
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

// 穷举方式  超时
//    private int count;
//
//    private static class Node {
//        private Node(int num) {
//            this.num = num;
//        }
//
//        private int num;
//        private Node lft;
//        private Node rgt;
//    }
//
//    public int climbStairs(int n) {
//        Node root = new Node(1);
//        create(root, n+1);
//        return count;
//    }
//
//    private void create(Node node, int threshold) {
//        if (node.num + 1 < threshold) {
//            node.lft = new Node(node.num + 1);
//            create(node.lft, threshold);
//        } else {
//            if (node.num + 1 == threshold) {
//                count++;
//            }
//        }
//        if (node.num + 2 < threshold) {
//            node.rgt = new Node(node.num + 2);
//            create(node.rgt, threshold);
//        } else {
//            if (node.num + 2 == threshold) {
//                count++;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(4));
    }


}
