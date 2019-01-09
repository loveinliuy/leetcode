package h1.t5;

import java.util.Stack;

/**
 * @author zhangshibo
 */
public class MinStack {

    private static class Node {
        Integer value;
        Integer curMin;

        Node(int value, int curMin) {
            this.value = value;
            this.curMin = curMin;
        }
    }


    private Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            Node top = stack.peek();
            stack.push(new Node(x, Math.min(top.curMin, x)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            Node top = stack.peek();
            return top.value;
        }
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            Node top = stack.peek();
            return top.curMin;
        }
    }
}
