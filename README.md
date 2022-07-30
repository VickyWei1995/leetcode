



# leetcode

LeetCode刷题笔记。备战面试时，有幸看到谷歌大佬分享的刷题思路，沿用该思路记录自己的刷题历程。

将LeetCode的题目根据解题思路分为以下几类，选取经典题目练习。

## 贪心算法

[455 Assign Cookies(easy)](455/README.md)

[135 Candy](135/README.md)

[435 Non-overlapping Intervals (Medium) ](435/README.md)

## 双指针

[167 Two Sum II - Input array is sorted (Easy) ](167/README.md)

[88 Merge Sorted Array (Easy)](88/README.md)  

[142 Linked List Cycle II (Medium)](142/README.md) 

[76 MinimumWindow Substring (Hard)](76/README.md) 

## 二分

[ 69 Sqrt(x) (Easy)](69/README.md) 

[ 34 Find First and Last Position of Element in Sorted Array (Medium)](34/README.md) 

[81 Search in Rotated Sorted Array II (Medium)](81/README.md)



## 排序算法

### 快速排序

选取一个基准值，通常为arr[left]，把数组分为2个部分，左边部分的值都小于基准值，右边部分的值都大于基准值；返回这个分割index。然后对于left,index-1   index+1,right 这2个数组继续用该思路排序。

```java
void quickSort(int[] arr, int left, int right) {
    if (left < right) {
        int pivot = arr[left];
        int pivotIndex = left + 1;
        for (int i=left+1; i<=right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotIndex);
                pivotIndex += 1;
            }
        }
        pivotIndex -= 1;
        swap(arr, left, pivotIndex);
        quickSort(arr, left, pivotIndex-1);
        quickSort(arr, pivotIndex+1, right);
    }
}

```

### 归并排序

1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
4. 重复步骤 3 直到某一指针达到序列尾；
5. 将另一序列剩下的所有元素直接复制到合并序列尾。

```java
// 不断划分，直到数组只剩下一个元素。这个数组是已排序的最小单元
// 然后merge
void mergeSort(int[] arr) {
    if (arr.length < 2) {
        return;
    }
    int l=0, r=arr.length;
    int mid= l + (r-l)/2;
    int[] left = Arrays.copyOfRange(arr, l, mid);
    int[] right = Arrays.copyOfRange(arr, mid, r);
    mergeSort(left);
    mergeSort(right);
    int[] temp = merge(left, right);
    for (int i=0; i<temp.length; i++) {
        arr[i] = temp[i];
    }
}

int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i=0, j=0;
    int index = 0;
    while (i<left.length && j<right.length) {
        if (left[i] < right[j]) {
            result[index++] = left[i++];
        } else {
            result[index++] = right[j++];
        }
    }
    for (;i<left.length;) {
        result[index++] = left[i++];
    }
    for(;j<right.length;) {
        result[index++] = right[j++];
    }
    return result;
}
```

### 桶排序

<img src="./sort.png" alt="sort" style="zoom:80%;" />

1. 额外空间充足的情况下，尽量增大桶的数量
2. 使用的映射函数能够将输入的N个数均匀分配到K个桶中

### 冒泡排序

1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
3. 针对所有的元素重复以上的步骤，除了最后一个。
4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

```java
void bubbleSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
        boolean swap = false;
        for (int j=1; j<arr.length-i;j++) {
            if (arr[j-1] > arr[j]) {
                swap(arr, j-1 , j);
                swap = true;
            }
        }
        if (!swap) {
            break;
        }
    }
}
```

### 选择排序

1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
3. 重复第二步，直到所有元素均排序完毕。

```java
void selectionSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
        int minIndex = i;
        for (int j=i+1; j<arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr, i, minIndex);
    }
}
```

### 插入排序

将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。

插入的时候，对于排序的数组进行倒序遍历，直接进行交换，从而把未排序的元素传送到合适的位置。

```java
void insertSort(int[] arr) {
    for (int i=1; i<arr.length; i++) {
        int index = i;
        int current = arr[i];
        for (int j=i-1; j>=0;j--) {
            if (arr[j] > current) {
                swap(arr, index, j);
                index -=1;
            } else {
                break;
            }
        }
    }
}
```



[215 Kth Largest Element in an Array (Medium) ](215/README.md)

[347 Top K Frequent Elements (Medium)](347/README.md)

### 

## 搜索算法

### DFS(深度优先)

深度优先搜索 depth-first seach DFS 在搜索到一个新的节点时，立即对新节点进行遍历。因此遍历用先入后出的栈来实现，也可以用与栈等价的递归来实现。对于树结构，由于总是对新节点调用遍历，因此看起来是向着“深”的方向前进。

### BFS(广度优先)

广度优先搜索（breadth-first search，BFS）不同与深度优先搜索，它是一层层进行遍历的，因此需要用先入先出的队列而非先入后出的栈进行遍历。由于是按层次进行遍历，广度优先搜索时按照“广”的方向进行遍历的，也常常用来处理最短路径等问题。

### 回溯法

回溯法 backtracking 是优先搜索的一种特殊情况。又称为试探法，常用于记录节点状态的深度优先搜索。通常来说，排列、组合、选择类问题使用回溯法比较方便。

顾名思义，回溯法的核心是回溯。在搜索到某一节点的时候 如果我们发现目前的节点及其子 节点并不是所求目标时，我们回溯到原来的节点继续搜索 并且把在目前节点修改的状态还原。

[695 Max Area of Island (Easy)](695/README.md)

[417 Pacific AtlanticWater Flow (Medium)](417/README.md)

[547 Number of Provinces(Medium)](547/README.md)

[46 Permutations (Medium)](46/README.md)

[77 Combinations (Medium)](77/README.md)

[79 Word Search (Medium)](79/README.md)

[51 N-Queens (Hard)](51/README.md)

[934 Shortest Bridge (Medium)](934/README.md)

[131 Palindrome Partitioning(Medium)](131/README.md)

[127 Word Ladder(hard)](127/README.md)



## 动态规划

通俗一点来讲，动态规划和其它遍历算法（如深/广度优先搜索）都是将原问题拆成多个子问题然后求解，他们之间最本质的区别是，动态规划保存子问题的解，避免重复计算。解决动态规划问题的关键是找到状态转移方程，这样我们可以通过计算和储存子问题的解来求解最终问题。在一些情况下，动态规划可以看成是带有状态记录（memoization）的优先搜索。状态记录的意思为，如果一个子问题在优先搜索时已经计算过一次，我们可以把它的结果储存下来，之后遍历到该子问题的时候可以直接返回储存的结果。



[70 Climbing Stairs (Easy)](70/README.md)

[198 House Robber (Easy)](198/README.md)

[413 Arithmetic Slices (Medium)](413/README.md)

[64 Minimum Path Sum (Medium)](64/README.md)

[542 01 Matrix (Medium)](542/README.md)

[221 Maximal Square (Medium)](221/README.md)

[279 Perfect Squares (Medium) ](279/README.md)

[91 Decode Ways (Medium)](91/README.md)

[139 Word Break (Medium)](139/README.md)

[300 Longest Increasing Subsequence (Medium)](300/README.md)

[1143 Longest Commom Subsequence (Medium)](1143/README.md)

### 背包问题

背包问题是一种组合优化的NP 完全问题：有N 个物品和容量为W 的背包，每个物品都有自己的体积w 和价值v，求拿哪些物品可以使得背包所装下物品的总价值最大。如果限定每种物品只能选择0 个或1 个，则问题称为0-1 背包问题；如果不限定每种物品的数量，则问题称为无界背包问题或完全背包问题。

我们可以用动态规划来解决背包问题。以0-1 背包问题为例。我们可以定义一个二维数组dp存储最大价值，其中dp[i][j] 表示前i 件物品体积不超过j 的情况下能达到的最大价值。在我们遍历到第i 件物品时，在当前背包总容量为j 的情况下，如果我们不将物品i 放入背包，那么dp[i][j]= dp[i-1][j]，即前i 个物品的最大价值等于只取前i-1 个物品时的最大价值；如果我们将物品i 放入背包，假设第i 件物品体积为w，价值为v，那么我们得到dp[i][j] = dp[i-1][j-w] + v。我们只需在遍历过程中对这两种情况取最大值即可，总时间复杂度和空间复杂度都为O(NW)。

![package-01-1](package-01-1.png)

我们可以进一步对0-1 背包进行空间优化，将空间复杂度降低为O.W.。如图所示，假设我们目前考虑物品i = 2，且其体积为w = 2，价值为v = 3；对于背包容量j，我们可以得到dp[2][j]= max(dp[1][j], dp[1][j-2] + 3)。这里可以发现我们永远只依赖于上一排i = 1 的信息，之前算过的其他物品都不需要再使用。因此我们可以去掉dp 矩阵的第一个维度，在考虑物品i 时变成dp[j]= max(dp[j], dp[j-w] + v)。这里要注意我们在遍历每一行的时候必须逆向遍历，这样才能够调用上一行物品i-1 时dp[j-w] 的值；若按照从左往右的顺序进行正向遍历，则dp[j-w] 的值在遍历到  j 之前就已经被更新成物品i 的值了。

![package-01-2](package-01-2.png)

在完全背包问题中，一个物品可以拿多次。这样，我们就得到了完全背包问题的状态转移方程：dp[i][j] = max(dp[i-1][j], dp[i][j-w] + v)，其与0-1 背包问题的差别仅仅是把状态转移方程中的第二个i-1 变成了i。

![package-01-3](package-01-3.png)同样的，我们也可以利用空间压缩将时间复杂度降低为O(W)。这里要注意我们在遍历每一

行的时候必须正向遍历，因为我们需要利用当前物品在第j-w 列的信息。

![package-01-4](/Users/wy/Documents/GitHub/leetcode/package-01-4.png)

[416 Partition Equal Subset Sum (Medium)](416/README.md)

[474 Ones and Zeroes (Medium)](474/README.md)

[322 Coin Change (Medium)](322/README.md)

[72 Edit Distance (Hard)](72/README.md)

[650 2 Keys Keyboard (Medium)](650/README.md)

[10 Regular Expression Matching (Hard)](10/README.md)

[121 Best Time to Buy and Sell Stock (Easy) ](121/README.md)

[122 Best Time to Buy and Sell Stock II(Medium)](122/README.md)

[188 Best Time to Buy and Sell Stock IV(hard)](188/README.md)

[309 Best Time to Buy and Sell Stock with Cooldown (Medium)](309/README.md)



## 分治法

顾名思义，分治问题由“分”（divide）和“治”（conquer）两部分组成，通过把原问题分为子问题，再将子问题进行处理合并，从而实现对原问题的求解。我们在排序章节展示的归并排序就是典型的分治问题，其中“分”即为把大数组平均分成两个小数组，通过递归实现，最终我们会得到多个长度为1 的子数组;“治”即为把已经排好序的两个小数组合成为一个排好序的大数组，从长度为1 的子数组开始，最终合成一个大数组。

我们也使用数学表达式来表示这个过程。定义T(n) 表示处理一个长度为n 的数组的时间复杂度，则归并排序的时间复杂度递推公式为T(n) = 2T(n/2) +O(n)。其中2T(n/2) 表示我们分成了

两个长度减半的子问题，O(n) 则为合并两个长度为n/2 数组的时间复杂度。

那么怎么利用这个递推公式得到最终的时间复杂度呢？这里我们可以利用著名的主定理

（Master theorem）求解：

![division](division.png)通过主定理我们可以知道，归并排序属于第二种情况，且时间复杂度为O(n log n)。其他的分

治问题也可以通过主定理求得时间复杂度。

[241 DifferentWays to Add Parentheses (Medium)](241/README.md)

## **巧解数学问题**

### **公倍数和公因数**

利用辗转相除法，我们可以很方便地求得两个数的最大公因数（greatest common divisor，gcd）；将两个数相乘再除以最大公因数即可得到最小公倍数（least common multiple, lcm）。

![math-1](math-1.png)

进一步地，我们也可以通过扩展欧几里得算法（extended gcd）在求得a 和b 最大公因数的同时，也得到它们的系数x 和y，从而使ax + by = gcd(a, b)。

![math-2](math-2.png)

### **质数**

[204 Count Primes (Medium) ](204/README.md)

[172 Factorial Trailing Zeroes](172/README.md)

### **随机**

 Fisher-Yates 洗牌算法：原理是通过随机交换位置来实现随机打乱，有正向和反向两种写法，且实现非常方便。

![shuffle](shuffle.png)

## **位运算**

![bit-1](bit-1.png)

[461 Hamming Distance (Easy) ](461/README.md)

[190  Reverse Bits (Easy)](190/README.md)

[342 Power of Four (Easy)](342/README.md)

[318 Maximum Product of Word Lengths (Medium) ](318/README.md)

[338 Counting Bits (Medium) ](338/README.md)

## **巧用数据结构**

### **数组**

[448 Find All Numbers Disappeared in an Array (Easy) ](448/README.md)

[48 Rotate Image (Medium) ](48/README.md)

[240 Search a 2D Matrix II (Medium)](240/README.md)

[769 Max Chunks To Make Sorted (Medium) ](769/README.md)



### **栈和队列**

[232 Implement Queue using Stacks (Easy)](232/README.md)

[155 Min Stack (Easy) ](155/README.md)

[20 Valid Parentheses (Easy)](/README.md)



### **单调栈**

单调栈通过维持栈内值的单调递增（递减）性，在整体O(n) 的时间内处理需要大小比较的问题。

[739 Daily Temperatures (Medium)](739/README.md)



### **优先队列/堆**

优先队列（priority queue）可以在O(1) 时间内获得最大值，并且可以在O(log n) 时间内取出最大值或插入任意值。

优先队列常常用堆（heap）来实现。**堆是一个完全二叉树**，其每个节点的值总是大于等于子节点的值。实际实现堆时，我们通常用一个数组而不是用指针建立一个树。这是因为堆是完全二叉树，所以用数组表示时，位置i 的节点的父节点位置一定为i/2，而它的两个子节点的位置又一定分别为2i 和2i+1。

以下是堆的实现方法，其中最核心的两个操作是**上浮** 和 **下沉**：如果一个节点比父节点大，那么需要交换这个两个节点；交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操作，我们称之为上浮；类似地，如果一个节点比父节小，也需要不断地向下进行比较和交换操作，我们称之为下沉。如果一个节点有两个子节点，我们总是交换最大的子节点。

[23 Merge k Sorted Lists (Hard)](23/README.md)



### **双端队列**

[239 Sliding Window Maximum(hard)](239/README.md)



### **哈希表**

[1 Two Sum (Easy) ](1/README.md)

[128  Longest Consecutive Sequence (Medium) ](128/README.md)



## **树**

[104 Maximum Depth of Binary Tree (Easy)](104/README.md)

[110 Balanced Binary Tree (Easy)](110/README.md)

[437 Path Sum III (Medium)](437/README.md)

[101 Symmetric Tree (Easy)](101/README.md)

[1110 Delete Nodes And Return Forest (Medium)](1110/README.md)

[102 Binary Tree Level Order Traversal(Medium)](102/README.md)

### **前序遍历**

```java
void preOrder(TreeNode root) {
    visit(root);
    preOrder(root.left);
    preOrder(root.right);
}
```

### **中序遍历**

```java
void inOrder(TreeNode root) {
    inOrder(root.left);
    visit(root);
    inOrder(root.right);
}
```

### **后序遍历**

```java
void postOrder(TreeNode root) {
    postOrder(root.left);
    postOrder(root.right);
    visit(root);
}
```

### **二叉查找树**

二叉查找树（Binary Search Tree, BST）是一种特殊的二叉树：对于每个父节点，其左子树中所有节点的值小于等于父结点的值，其右子树中所有节点的值大于等于父结点的值。因此对于一个二叉查找树，我们可以在O.n log n. 的时间内查找一个值是否存在：从根节点开始，若当前节点的值大于查找值则向左下走，若当前节点的值小于查找值则向右下走。同时因为二叉查找树是有序的，对其中序遍历的结果即为排好序的数组。

[98 Validate Binary Search Tree(Medium)](98/README.md)

### **字典树**

字典树（Trie）用于判断字符串是否存在或者是否具有某种字符串前缀。

对于大数量单词的存储，如果使用哈希的话，在其中搜索一个单词的实际开销也是非常大的，且无法轻易支持搜索单词前缀。然而由于一个英文单词的长度n 通常在10 以内，如果我们使用字典树，则可以在O(n)——近似O(1)的时间内完成搜索，且额外开销非常小。

![dictionary-tree](dictionary-tree.png)

## **字符串常见题型**

### **字符串比较**

[242 Valid Anagram (Easy)](242/README.md)

[205 Isomorphic Strings (Easy)](205/README.md)

[647 Palindromic Substrings (Medium)](647/README.md)

[696 Count Binary Substrings (Easy)](696/README.md)

[316 Remove Duplicate Letters(Medium)](316/README.md)

[395  Longest Substring with At Least K Repeating Characters(Medium)](395/README.md)

