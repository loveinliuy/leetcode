package h2.t3;

import utils.ListNode;

/**
 * @author zhangshibo
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.print();
        new DeleteNodeInLinkedList().deleteNode(n2);
        n1.print();
    }
}
