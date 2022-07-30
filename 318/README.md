# 318 Maximum Product of Word Lengths

https://leetcode.com/problems/maximum-product-of-word-lengths/

## 思路

给定多个字母串，求其中任意两个字母串的长度乘积的最大值，且这两个字母串不能含有相同字母。

开始想的方法是每两个单词先比较，如果没有相同字母，则计算其长度之积，然后每次更新结果就能找到最大值。但是我开始想的两个单词比较的方法是利用哈希表先将一个单词的所有出现的字母存入哈希表，然后检查另一个单词的各个字母是否在哈希表出现过，若都没出现过，则说明两个单词没有相同字母，则计算两个单词长度之积并更新结果。但是这种判断方法无法通过OJ的大数据集，

上网搜大神们的解法，都是用了mask，因为题目中说都是小写字母，那么只有26位，一个整型数int有32位，我们可以用后26位来对应26个字母，若为1，说明该对应位置的字母出现过，那么每个单词的都可由一个int数字表示，两个单词没有共同字母的条件是这两个int数 相与 为0，用这个判断方法可以通过OJ

## Java

```java
class Solution {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        int result = 0;
        for (int j=0; j<words.length; j++) {
            int mask = 0;
            String word = words[j];
            for (int i=0; i<word.length(); i++) {
                int moveNum = word.charAt(i) - 'a';
                mask |= (1 << moveNum);
            }
            masks[j] = mask;
            for (int k=0; k<j;k++) {
                if ((masks[k] & masks[j]) == 0) {
                    result = Math.max(result, word.length() * words[k].length());
                }
            }
        }
        return result;
    }
}
```

