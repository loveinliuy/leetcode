package h1.t4;

import utils.ListNode;
import utils.ListNodeHelper;

/**
 * @author zhangshibo
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;
        ListNode meet = null;
        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                meet = faster;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        ListNode node = head;
        while (node != meet) {
            node = node.next;
            meet = meet.next;
        }
        return node;
    }

    public static void main(String[] args){
//        ListNode node = ListNodeHelper.newCycleListNode();
        ListNode node = new ListNode(1);
        ListNode n2 = new ListNode(2);
        node.next = n2;
        n2.next = node;
        System.out.println(new DetectCycle().detectCycle(node));
    }
}
