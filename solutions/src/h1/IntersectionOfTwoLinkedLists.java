package h1;

import utils.ListNode;

/**
 * @author zhangshibo
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode lastA = headA;
//        while (lastA.next != null) {
//            lastA = lastA.next;
//        }
//        lastA.next = headA;
//
//        ListNode faster = headB;
//        ListNode slower = headB;
//        while (faster.next != null && faster.next.next != null) {
//            faster = faster.next.next;
//            slower = slower.next;
//            if (faster == slower) {
//                slower = headB;
//                while (slower != faster) {
//                    slower = slower.next;
//                    faster = faster.next;
//                }
//                lastA.next = null;
//                return faster;
//            }
//        }
//        lastA.next = null;
//        return null;
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n6.next = n4;
        n4.next = n5;

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(n6, n1));
    }
}
