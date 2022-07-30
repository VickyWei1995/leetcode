# 46 Permutations

https://leetcode.com/problems/permutations/



## 思路

- 递归，先获取数组-1的排列组合，然后将最后一位元素依次插入到排列组合的各个相邻位置中。
- 直接对原数组进行操作。交换任意2个元素的位置，得到一组排列，将这组排列保存到结果数组中。再将原先交换的元素归位，重新开始交换得到下一组排列

## Java

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
            if (nums.length <= 1) {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return result;
            }
            int[] subNums = Arrays.copyOf(nums, nums.length-1);
            int lastNum = nums[nums.length-1];
            List<List<Integer>> subResult = permute(subNums);
            for (List<Integer> resultList: subResult) {
                for (int i=0; i<=resultList.size(); i++) {
                    List<Integer> copy = new ArrayList<>(resultList);
                    copy.add(i, lastNum);
                    result.add(copy);
                }
            }
            return result;
    }
}
```

