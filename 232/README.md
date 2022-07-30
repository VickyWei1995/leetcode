# 232 Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/



## 思路

尝试使用栈（stack）来实现队列（queue）。我们可以用两个栈来实现一个队列：因为我们需要得到先入先出的结果，所以必定要通过一个额外栈翻转一次数组。这个翻转过程既可以在插入时完成，也可以在取值时完成。

## Java

```java
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

