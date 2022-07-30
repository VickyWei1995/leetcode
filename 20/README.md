# 20 Valid Parentheses

https://leetcode.com/problems/valid-parentheses/



## 思路

给定一个只由左右原括号、花括号和方括号组成的字符串，求这个字符串是否合法。合法的定义是每一个类型的左括号都有一个右括号一一对应，且括号内的字符串也满足此要求。

括号匹配是典型的使用栈来解决的问题。我们从左往右遍历，每当遇到左括号便放入栈内，遇到右括号则判断其和栈顶的括号是否是统一类型，是则从栈内取出左括号，否则说明字符串不合法。

## Java

```java
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
```

