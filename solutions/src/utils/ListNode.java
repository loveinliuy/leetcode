package utils;

/**
 * @author zhangshibo
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x){
        this.val = x;
    }

    public void print(){
        doPrint();
        System.out.println();
    }

    private void doPrint(){
        System.out.print(val);
        if(next != null){
            System.out.print(" -> ");
            next.doPrint();
        }
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
