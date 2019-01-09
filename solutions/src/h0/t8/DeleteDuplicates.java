package h0.t8;

/**
 * @author zhangshibo
 */
public class DeleteDuplicates {

    private static class ListNode {
        int val;
        ListNode next;

        private ListNode(int x) {
            this.val = x;
        }

        public void print(){
            System.out.print(val);
            if(next != null){
                System.out.print(" -> ");
                next.print();
            }
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        delete(head);
        return head;
    }

    private void delete(ListNode node) {
        if(node == null){
            return;
        }
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
//        n3.next= n4;
        n1.print();
        System.out.println();

        ListNode result = new DeleteDuplicates().deleteDuplicates(n1);

        result.print();
    }
}
