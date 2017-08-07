package hundred.h1.ten.t2;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/14].
 */
public class MergeKSortedLists {

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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (l1 != null && l2 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            if (l1.val <= l2.val) {
                p.next = l1;
                l1.next = null;
                p = l1;
                l1 = l1_next;
            } else {
                p.next = l2;
                l2.next = null;
                p = l2;
                l2 = l2_next;
            }
        }


        while (l1 != null) {
            ListNode l1_next = l1.next;
            p.next = l1;
            l1.next = null;
            p = l1;
            l1 = l1_next;
        }

        while (l2 != null) {
            ListNode l2_next = l2.next;
            p.next = l2;
            l2.next = null;
            p = l2;
            l2 = l2_next;
        }

        return l3.next;
    }

    // my solution
//    public ListNode mergeKLists(ListNode[] lists) {
//        int len = lists.length;
//        if (len == 0) {
//            return null;
//        }
//
//        while (len > 1) {
//            if (len % 2 == 0) {
//                int nlen = len / 2;
//                for (int i = 0; i < nlen; i++) {
//                    lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
//                }
//                len = nlen;
//            } else {
//                int nlen = (len + 1) / 2;
//                for (int i = 0; i < nlen - 1; i++) {
//                    lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
//                }
//                len = nlen;
//            }
//        }
//
//        return lists[0];
//    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode l1 = mergeHelper(lists, start, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(-9);
        ListNode l2 = new ListNode(-9);
        ListNode l3 = new ListNode(-6);
        ListNode l4 = new ListNode(-2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode k1 = new ListNode(-9);
        ListNode k2 = new ListNode(-9);
        ListNode k3 = new ListNode(-7);
        ListNode k4 = new ListNode(-5);
        ListNode k5 = new ListNode(-3);
        ListNode k6 = new ListNode(0);
        ListNode k7 = new ListNode(2);
        ListNode k8 = new ListNode(4);
        k1.next = k2;
        k2.next = k3;
        k3.next = k4;
        k4.next = k5;
        k5.next = k6;
        k6.next = k7;
        k7.next = k8;

        ListNode m1 = new ListNode(-4);
        ListNode m2 = new ListNode(-4);
        ListNode m3 = new ListNode(1);
        ListNode m4 = new ListNode(1);
        ListNode m5 = new ListNode(2);
        ListNode m6 = new ListNode(2);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;

        ListNode result = new MergeKSortedLists().mergeKLists(new ListNode[]{l1, k1, m1});

        System.out.println(result);
    }

}
