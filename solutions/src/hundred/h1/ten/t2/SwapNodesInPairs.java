package hundred.h1.ten.t2;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/13].
 */
public class SwapNodesInPairs {

    public static class ListNode {
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
//    public ListNode swapPairs(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode result = new ListNode(-1);
//        ListNode resultCursor = result;
//
//        ListNode headCursor = head;
//
//        int pos = 0;
//        int last = -1;
//        while (headCursor != null) {
//            if (pos % 2 == 1) {
//                resultCursor.next = new ListNode(headCursor.val);
//                resultCursor = resultCursor.next;
//                resultCursor.next = new ListNode(last);
//                resultCursor = resultCursor.next;
//            }
//            last = headCursor.val;
//            headCursor = headCursor.next;
//            pos++;
//        }
//        if (pos % 2 == 1) {
//            resultCursor.next = new ListNode(last);
//        }
//
//        return result.next;
//    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode subHead = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next = subHead;
        newHead.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;

        System.out.println(head);

        System.out.println(new SwapNodesInPairs().swapPairs(head));
    }
}
