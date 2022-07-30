# 77 Combinations

https://leetcode.com/problems/combinations/



## 思路

给定数字n和k。求从1~n中任选k个数字的所有组合

- 递归。获取(n-1,k)的，这些肯定是符合要求的；再获取(n-1, k-1)的，这些是缺少数字n的，(n-1, k-1)的所有组合插入数字n。最后合并这2个结果
- 递归。初始化一个长度为k的数组，第一个位置可填范围为1~n中的任意数字，第二个位置为大于第一个位置数字且小于n的。完全填满的数组可以放到结果数组中

## Java

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> result = new ArrayList<>();
            if (k == 1) {
                for (int i=1; i<=n; i++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    result.add(temp);
                }
                return result;
            }
            if (k == n) {
                List<Integer> temp = new ArrayList<>();
                for (int i=1; i<=n; i++) {
                    temp.add(i);
                }
                result.add(temp);
                return result;
            }

            List<List<Integer>> subResult = combine(n-1, k-1);
            result = combine(n-1, k);
            Iterator<List<Integer>> listIterator = subResult.iterator();
            while (listIterator.hasNext()) {
                List<Integer> subList = listIterator.next(); // must be called before you can call i.remove()
                subList.add(n);
                result.add(subList);
            }
        return result;
    }
}
```

