# 91 Decode Ways

https://leetcode.com/problems/decode-ways/





## 思路

已知字母A-Z 可以表示成数字1-26。给定一个数字串，求有多少种不同的字符串等价于这个数字串。需要注意 以0开头、大于26的情况特殊处理



## Java

```java
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
            if (s.charAt(0) == '0') {
                return 0;
            }
            dp[0] = 1;
            for (int i=1; i< s.length(); i++) {
                int tempResult = 0;
                if (s.charAt(i)!='0') {
                    tempResult += dp[i-1];
                }
                if (s.charAt(i-1)!='0' && Integer.parseInt(s.substring(i-1,i+1)) <= 26) {
                    if (i-2 >=0) {
                        tempResult += dp[i-2];
                    } else {
                        tempResult += 1;
                    }
                }
                dp[i] = tempResult;
            }
            return dp[s.length() -1];
    }
}
```

