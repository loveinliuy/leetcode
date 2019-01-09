package h2.t0;

import utils.ListNode;
import utils.ListNodeHelper;

import java.util.Stack;

/**
 * @author zhangshibo
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverseListIter(head);
    }

    public ListNode reverseListIter(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListRecursively(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public ListNode reverseListNormal(ListNode head) {
        // 空间 O(n) 时间 O(2n)
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = stack.pop();
        ListNode tmp = result;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeHelper.newListNode();
        head.print();

        ListNode result = new ReverseLinkedList().reverseList(head);
        result.print();
    }


}
