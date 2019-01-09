package h0.t0;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        void print() {
            ListNode cur = this;
            while (cur.next != null) {
                System.out.print(cur.val + " -> ");
                cur = cur.next;
            }
            System.out.println(cur.val);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode(0);
        ListNode rt = result;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int v1 = 0, v2 = 0;
            if (temp1 != null) {
                v1 = temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                v2 = temp2.val;
                temp2 = temp2.next;
            }
            int vr = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            ListNode t = new ListNode(vr);
            rt.next = t;
            rt = t;
        }
        if (carry > 0) {
            rt.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        l1.print();

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l2.print();

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        result.print();

    }
}
