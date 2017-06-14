/**
 * description:
 *
 * @author zhangshibo  [2017/6/13].
 */
public class MergeTwoSortedLists {

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode s1 = new ListNode(0);
        s1.next = l1;
        ListNode s2 = new ListNode(0);
        s2.next = l2;
        ListNode res = new ListNode(0);
        ListNode iter = new ListNode(0);
        res.next = iter;
        while (s1.next != null || s2.next != null) {
            ListNode n1 = s1.next;
            ListNode n2 = s2.next;
            if (n1 != null) {
                if (n2 != null) {
                    if (n1.val > n2.val) {
                        iter.next = new ListNode(n2.val);
                        s2 = s2.next;
                    } else {
                        iter.next = new ListNode(n1.val);
                        s1 = s1.next;
                    }
                } else {
                    iter.next = new ListNode(n1.val);
                    s1 = s1.next;
                }
            } else {
                iter.next = new ListNode(n2.val);
                s2 = s2.next;
            }
            iter = iter.next;
        }
        return res.next.next;
    }


    // better solution
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return null;
//        }
//
//        ListNode l3 = new ListNode(0);
//        ListNode p = l3;
//        while (l1 != null && l2 != null) {
//            ListNode l1_next = l1.next;
//            ListNode l2_next = l2.next;
//
//            if (l1.val <= l2.val) {
//                p.next = l1;
//                l1.next = null;
//                p = l1;
//                l1 = l1_next;
//            } else {
//                p.next = l2;
//                l2.next = null;
//                p = l2;
//                l2 = l2_next;
//            }
//        }
//
//
//        while (l1 != null) {
//            ListNode l1_next = l1.next;
//            p.next = l1;
//            l1.next = null;
//            p = l1;
//            l1 = l1_next;
//        }
//
//        while (l2 != null) {
//            ListNode l2_next = l2.next;
//            p.next = l2;
//            l2.next = null;
//            p = l2;
//            l2 = l2_next;
//        }
//
//        return l3.next;
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(12);
        ListNode l3 = new ListNode(35);
        ListNode l4 = new ListNode(40);
        ListNode l5 = new ListNode(53);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode k1 = new ListNode(1);
        ListNode k2 = new ListNode(11);
        ListNode k3 = new ListNode(33);
        ListNode k4 = new ListNode(45);
        ListNode k5 = new ListNode(58);
        k1.next = k2;
        k2.next = k3;
        k3.next = k4;
        k4.next = k5;

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(l1, k1);

        System.out.println(result);
    }
}
