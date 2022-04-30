# 135 Candy(hard)

## Description

There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

Return *the minimum number of candies you need to have to distribute the candies to the children*.

 

## **Example 1:**

```
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
```

## **Example 2:**

```
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
```

## **Constraints:**

- `n == ratings.length`
- `1 <= n <= 2 * 104`
- `0 <= ratings[i] <= 2 * 104`



## 思路

先给每人一个糖果；2次遍历，每次只更新相邻一边的糖果数量。第一次遍历，从左到右，更新右边的糖果数量；第二次遍历，从右到左，更新左边的糖果数量，只增不减



## Java

```java
class Solution {
    public int candy(int[] ratings) {
        int[] candyCountArray = new int[ratings.length];
            Arrays.fill(candyCountArray, 1);
            for (int i=1; i<candyCountArray.length; i++) {
                if (ratings[i] > ratings[i-1]) {
                    candyCountArray[i] = candyCountArray[i-1] + 1;
                }
            }
            for (int i=ratings.length-1; i>0; i--) {
                if (ratings[i-1] > ratings[i]) {
                    candyCountArray[i-1] = Math.max(1 + candyCountArray[i],candyCountArray[i-1]);
                }
            }
            System.out.print(Arrays.toString(candyCountArray));
            return Arrays.stream(candyCountArray).sum();
    }
}
```

## cpp

```cpp
int candy(vector<int>& ratings) {
  int size = ratings.size();
  if (size < 2) {
  	return size;
  }
  vector<int> num(size, 1);
  for (int i = 1; i < size; ++i) {
    if (ratings[i] > ratings[i-1]) {
    	num[i] = num[i-1] + 1;
    }
  }
  for (int i = size - 1; i > 0; --i) {
    if (ratings[i] < ratings[i-1]) {
    	num[i-1] = max(num[i-1], num[i] + 1);
    }
  }
	return accumulate(num.begin(), num.end(), 0); 
  // std::accumulate 可以很方便地求和
}
```

