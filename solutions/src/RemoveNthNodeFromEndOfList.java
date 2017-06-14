/**
 * description:
 *
 * @author zhangshibo  [2017/6/12].
 */
public class RemoveNthNodeFromEndOfList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp.next != null) {
                sb.append(temp.val).append(" -> ");
                temp = temp.next;
            }
            sb.append(temp.val);
            return sb.toString();
        }
    }

    // my solution
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode start = new ListNode(0);
//        start.next = head;
//        ListNode beforeRemove = start;
//        ListNode toRemove = start;
//        ListNode iter = start;
//        int removeLen = 0;
//        int totalLen = 0;
//        while (iter.next != null) {
//            totalLen++;
//            if (totalLen - removeLen == n) {
//                removeLen++;
//                beforeRemove = toRemove;
//                toRemove = toRemove.next;
//            }
//            iter = iter.next;
//        }
//        beforeRemove.next = toRemove.next;
//        return start.next;
//    }

    // better solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
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

        System.out.println(l1);

        ListNode result = new RemoveNthNodeFromEndOfList().removeNthFromEnd(l1, 1);

        System.out.println(result);
    }
}
