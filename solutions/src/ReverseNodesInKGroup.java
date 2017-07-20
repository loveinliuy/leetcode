import java.util.Stack;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/13].
 */
public class ReverseNodesInKGroup {

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


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // 找到第k+1个节点
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);// 继续对第k+1个节点进行继续处理
            while (count-- > 0) { // 对当前找到的序列进行翻转
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        System.out.println(head);

        int k = 3;
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(head, k));
    }

}
