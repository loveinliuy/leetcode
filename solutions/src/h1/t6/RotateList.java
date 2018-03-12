package h1.t6;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class RotateList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode iter = this;
            while (iter != null) {
                sb.append(iter.val).append(" ");
                iter = iter.next;
            }
            return sb.toString();
        }
    }

    /**
     * 思路：
     * 使用两个指针，一个为迭代指针，一个为与迭代相差k个节点的指针。
     * 当迭代指针到达最末时，重组关系。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        // 第倒数k+1个
        ListNode kth;
        ListNode iter = head;
        int len = 0;
        while (k > 0) {
            k--;
            len++;
            if (iter.next == null) {
                iter = head;
                k = k % len;
                continue;
            }
            iter = iter.next;
        }
        kth = head;
        while (iter.next != null) {
            kth = kth.next;
            iter = iter.next;
        }
        iter.next = head;
        head = kth.next;
        kth.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        System.out.println(new RotateList().rotateRight(l1, 18));
    }
}
