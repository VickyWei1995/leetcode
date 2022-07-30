package LeetCode;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValid(String s) {
            HashMap<Character,Character> bracketsMap = new HashMap<>();
            bracketsMap.put(')', '(');
            bracketsMap.put('}', '{');
            bracketsMap.put(']', '[');
            Stack<Character> brackets = new Stack<>();
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) =='{' || s.charAt(i) =='[') {
                    brackets.push(s.charAt(i));
                }
                if (s.charAt(i) == ')' || s.charAt(i) =='}' || s.charAt(i) ==']') {
                    if (brackets.empty()) {
                        return false;
                    }
                    Character popC = brackets.pop();
                    if (popC != bracketsMap.get(s.charAt(i))) {
                        return false;
                    }
                }
            }
            if (brackets.empty()) {
                return true;
            }
            return false;
        }
    }

}
