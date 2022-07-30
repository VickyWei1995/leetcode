package LeetCode;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> decStack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i=0; i<temperatures.length; i++) {
                while (!decStack.empty()) {
                    int preIndex = decStack.peek();
                    if (temperatures[i] <= temperatures[preIndex]) {
                        break;
                    }
                    decStack.pop();
                    res[preIndex] = i -preIndex;
                }
                decStack.push(i);
            }
            return res;
        }
    }
}
