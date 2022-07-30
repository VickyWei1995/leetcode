package LeetCode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    int num = stack1.pop();
                    stack2.push(num);
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    int num = stack1.pop();
                    stack2.push(num);
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    int num = stack1.pop();
                    stack2.push(num);
                }
            }
            return stack2.empty();
        }
    }
}
