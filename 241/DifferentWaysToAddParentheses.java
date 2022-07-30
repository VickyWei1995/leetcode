package LeetCode;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String test = "2*3-4*5";
        Solution s = new Solution();
        s.diffWaysToCompute(test);
    }

    static class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> result = new ArrayList<>();
            for (int i=0; i<expression.length(); i++) {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                    for (int l:left) {
                        for (int r: right) {
                            switch(expression.charAt(i)) {
                                case '+':
                                    result.add(l+r);
                                    break;
                                case '-':
                                    result.add(l-r);
                                    break;
                                default:
                                    result.add(l*r);
                                    break;
                            }
                        }
                    }
                }
            }
            if (result.size() == 0) {
                result.add(Integer.parseInt(expression));
            }
            return result;
        }

        private int helper(char op, int num1, int num2) {
            if (op == '+') {
                return num1 + num2;
            }
            if (op == '-') {
                return num1 - num2;
            }
            return num1 * num2;
        }


    }
}
