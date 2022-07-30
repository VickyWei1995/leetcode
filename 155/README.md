# 155 Min Stack

https://leetcode.com/problems/min-stack/



## 思路

设计一个最小栈，除了需要支持常规栈的操作外，还需要支持在O.1. 时间内查询栈内最小值的功能。我们可以额外建立一个新栈，栈顶表示原栈里所有值的最小值。每当在原栈里插入一个数字时，若该数字小于等于新栈栈顶，则表示这个数字在原栈里是最小值，我们将其同时插入新栈内。每当从原栈里取出一个数字时，若该数字等于新栈栈顶，则表示这个数是原栈里的最小值之一，我们同时取出新栈栈顶的值。

## Java

```java
class MinStack {
            private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MinStack() {
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
            if (!stack2.empty()  &&  stack1.peek().equals(stack2.peek())) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

