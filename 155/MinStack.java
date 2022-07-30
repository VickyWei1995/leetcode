package LeetCode;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        InnerMinStack minStack =  new InnerMinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.print(minStack.getMin());
        minStack.pop();
        System.out.print(minStack.getMin());
        minStack.pop();
        System.out.print(minStack.getMin());
    }

    static class InnerMinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public InnerMinStack() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int val) {
            if (stack2.empty() || stack2.peek() >= val) {
                stack2.push(val);
            }
            stack1.push(val);
        }

        public void pop() {
            if (!stack2.empty()  && stack1.peek().equals(stack2.peek())) {
                stack2.pop();
            }
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
