package h1.t4;

import utils.ListNode;
import utils.ListNodeHelper;

/**
 * @author zhangshibo
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeHelper.newCycleListNode();

        System.out.println(new LinkedListCycle().hasCycle(node));
    }
}
